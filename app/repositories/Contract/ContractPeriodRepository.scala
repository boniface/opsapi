package repositories.Contract

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Contract.ContractPeriod

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ContractPeriodRepository extends CassandraTable[ContractPeriodRepository, ContractPeriod]{

  object contractId extends StringColumn(this) with PartitionKey[String]

  object periodId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ContractPeriod = {
    ContractPeriod(
      contractId(r),
      periodId(r))
  }
}

object ContractPeriodRepository extends ContractPeriodRepository with RootConnector {
  override lazy val tableName = "contractPeriods"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contractPeriod: ContractPeriod): Future[ResultSet] = {
    insert
      .value(_.contractId, contractPeriod.ContractId)
      .value(_.periodId, contractPeriod.PeriodId)
      .future()
  }

  def getContractPeriodById(ContractId: String, PeriodId: String): Future[Option[ContractPeriod]] = {
    select.where(_.contractId eqs ContractId). and(_.periodId eqs PeriodId).one()
  }

  def getContractPeriods: Future[Seq[ContractPeriod]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getContractPeriod(ContractId: String, PeriodId: String): Future[Seq[ContractPeriod]] = {
    select.where(_.contractId eqs ContractId). and(_.periodId eqs PeriodId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ContractId: String, PeriodId: String): Future[ResultSet] = {
    delete.where(_.contractId eqs ContractId). and(_.periodId eqs PeriodId).future()
  }
}