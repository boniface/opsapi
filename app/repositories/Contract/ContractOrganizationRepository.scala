package repositories.Contract

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Contract.ContractOrganization

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ContractOrganizationRepository extends CassandraTable[ContractOrganizationRepository, ContractOrganization]{

  object contractId extends StringColumn(this) with PartitionKey[String]

  object organizationId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ContractOrganization = {
    ContractOrganization(
      contractId(r),
      organizationId(r))
  }
}

object ContractOrganizationRepository extends ContractOrganizationRepository with RootConnector {
  override lazy val tableName = "contractOrganizations"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contractOrganization: ContractOrganization): Future[ResultSet] = {
    insert
      .value(_.contractId, contractOrganization.ContractId)
      .value(_.organizationId, contractOrganization.OrganizationId)
      .future()
  }

  def getContractOrganizationById(ContractId: String, OrganizationId: String): Future[Option[ContractOrganization]] = {
    select.where(_.contractId eqs ContractId). and(_.organizationId eqs OrganizationId).one()
  }

  def getContractOrganizations: Future[Seq[ContractOrganization]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getContractOrganization(ContractId: String, OrganizationId: String): Future[Seq[ContractOrganization]] = {
    select.where(_.contractId eqs ContractId). and(_.organizationId eqs OrganizationId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ContractId: String, OrganizationId: String): Future[ResultSet] = {
    delete.where(_.contractId eqs ContractId). and(_.organizationId eqs OrganizationId).future()
  }
}