package repositories.Contract

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Contract.ContractItem

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ContractItemRepository extends CassandraTable[ContractItemRepository, ContractItem]{

  object contractId extends StringColumn(this) with PartitionKey[String]

  object itemId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ContractItem = {
    ContractItem(
      contractId(r),
      itemId(r))
  }
}

object ContractItemRepository extends ContractItemRepository with RootConnector {
  override lazy val tableName = "contractItems"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contractItem: ContractItem): Future[ResultSet] = {
    insert
      .value(_.contractId, contractItem.ContractId)
      .value(_.itemId, contractItem.ItemId)
      .future()
  }

  def getContractItemById(ContractId: String, ItemId: String): Future[Option[ContractItem]] = {
    select.where(_.contractId eqs ContractId). and(_.itemId eqs ItemId).one()
  }

  def getAllContractItems: Future[Seq[ContractItem]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getContractItem(ContractId: String, ItemId: String): Future[Seq[ContractItem]] = {
    select.where(_.contractId eqs ContractId). and(_.itemId eqs ItemId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ContractId: String, ItemId: String): Future[ResultSet] = {
    delete.where(_.contractId eqs ContractId). and(_.itemId eqs ItemId).future()
  }
}