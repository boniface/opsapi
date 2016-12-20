package repositories.Contract

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Contract

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/14.
  */
class ContractRepository extends CassandraTable[ContractRepository, Contract] {

  object Id extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending

  //object awardId extends StringColumn(this)

  object contractId extends StringColumn(this) with PartitionKey[String]

  object contractNumber extends StringColumn(this)

  object title extends StringColumn(this)

  object description extends StringColumn(this)

  //object value extends StringColumn(this)

  // object items extends StringColumn(this)

  // object suppliers  extends StringColumn(this)

  object status  extends StringColumn(this)

  // object period extends StringColumn(this)

  // object dateSigned extends StringColumn(this)

  object date extends DateTimeColumn(this) with PrimaryKey[DateTime] with ClusteringOrder[DateTime] with Descending

  //object documents extends StringColumn(this)

  override def fromRow(r: Row): Contract = {
    Contract(
      Id(r),
      contractId(r),
      contractNumber(r),
      title(r),
      description(r),
      status(r),
      date(r))
  }
}

object ContractRepository extends ContractRepository with RootConnector {
  override lazy val tableName = "contracts"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contract: Contract): Future[ResultSet] = {
    insert
      .value(_.Id, contract.id)
      .value(_.contractId, contract.id)
      .value(_.contractNumber, contract.contractNumber)
      .value(_.title, contract.title)
      .value(_.description, contract.description)
      .value(_.status, contract.status)
      .value(_.date, contract.date)
      .future()
  }

  def getContractById(ContractId: String): Future[Option[Contract]] = {
    select.where(_.contractId eqs ContractId).one()
  }

  def getAllContracts: Future[Seq[Contract]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getContract(ContractId: String): Future[Seq[Contract]] = {
    select.where(_.contractId eqs ContractId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ContractId: String): Future[ResultSet] = {
    delete.where(_.contractId eqs ContractId).future()
  }

}
