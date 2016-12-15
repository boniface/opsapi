package repositories.Item

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Item.ItemLot

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemLotRepository  extends CassandraTable[ItemLotRepository, ItemLot]{
  object ItemId extends StringColumn(this) with PartitionKey[String]
  object LotId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ItemLot = {
    ItemLot(
      ItemId(r),
      LotId(r))
  }

}

object ItemLotRepository extends ItemLotRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(itemLot: ItemLot): Future[ResultSet] = {
    insert
      .value(_.ItemId, itemLot.ItemId)
      .value(_.LotId, itemLot.LotId)
      .future()
  }

  def getItemLotById(ItemId: String, LotId: String): Future[Option[ItemLot]] = {
    select.where(_.ItemId eqs ItemId). and(_.LotId eqs LotId).one()
  }

  def getAllItemLots: Future[Seq[ItemLot]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getItemLot(ItemId: String, LotId: String): Future[Seq[ItemLot]] = {
    select.where(_.ItemId eqs ItemId). and(_.LotId eqs LotId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ItemId: String, LotId: String): Future[ResultSet] = {
    delete.where(_.ItemId eqs ItemId). and(_.LotId eqs LotId).future()
  }
}

