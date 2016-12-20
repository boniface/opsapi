package repositories.Contract

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Contract.ContractAward

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ContractAwardRepository extends CassandraTable[ContractAwardRepository, ContractAward]{

  object contractId extends StringColumn(this) with PartitionKey[String]

  object awardId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ContractAward = {
    ContractAward(
      contractId(r),
      awardId(r))
  }
}

object ContractAwardRepository extends ContractAwardRepository with RootConnector {
  override lazy val tableName = "contractAwards"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contractAward: ContractAward): Future[ResultSet] = {
    insert
      .value(_.contractId, contractAward.ContractId)
      .value(_.awardId, contractAward.AwardId)
      .future()
  }

  def getContractAwardById(ContractId: String, AwardId: String): Future[Option[ContractAward]] = {
    select.where(_.contractId eqs ContractId). and(_.awardId eqs AwardId).one()
  }

  def getAllContractAwards: Future[Seq[ContractAward]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getContractAward(ContractId: String, AwardId: String): Future[Seq[ContractAward]] = {
    select.where(_.contractId eqs ContractId). and(_.awardId eqs AwardId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ContractId: String, AwardId: String): Future[ResultSet] = {
    delete.where(_.contractId eqs ContractId). and(_.awardId eqs AwardId).future()
  }
}
