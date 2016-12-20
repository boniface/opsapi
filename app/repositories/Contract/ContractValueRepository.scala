package repositories.Contract

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Contract.ContractValue

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ContractValueRepository extends CassandraTable[ContractValueRepository, ContractValue]{

  object contractId extends StringColumn(this) with PartitionKey[String]

  object valueId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ContractValue = {
    ContractValue(
      contractId(r),
      valueId(r))
  }
}

object ContractValueRepository extends ContractValueRepository with RootConnector {
  override lazy val tableName = "contractValues"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contractValue: ContractValue): Future[ResultSet] = {
    insert
      .value(_.contractId, contractValue.ContractId)
      .value(_.valueId, contractValue.ValueId)
      .future()
  }

  def getContractValueById(ContractId: String, ValueId: String): Future[Option[ContractValue]] = {
    select.where(_.contractId eqs ContractId). and(_.valueId eqs ValueId).one()
  }

  def getContractValues: Future[Seq[ContractValue]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getContractValue(ContractId: String, ValueId: String): Future[Seq[ContractValue]] = {
    select.where(_.contractId eqs ContractId). and(_.valueId eqs ValueId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ContractId: String, ValueId: String): Future[ResultSet] = {
    delete.where(_.contractId eqs ContractId). and(_.valueId eqs ValueId).future()
  }
}