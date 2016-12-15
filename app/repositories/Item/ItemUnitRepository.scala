package repositories.Item

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Item.ItemUnit

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemUnitRepository extends CassandraTable[ItemUnitRepository, ItemUnit]{
  object ItemId extends StringColumn(this) with PartitionKey[String]
  object UnitId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ItemUnit = {
    ItemUnit(
      ItemId(r),
      UnitId(r))
  }

}

object ItemUnitRepository extends ItemUnitRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(itemPeriod: ItemUnit): Future[ResultSet] = {
    insert
      .value(_.ItemId, itemPeriod.ItemId)
      .value(_.UnitId, itemPeriod.UnitId)
      .future()
  }

  def getItemUnitById(ItemId: String, UnitId: String): Future[Option[ItemUnit]] = {
    select.where(_.ItemId eqs ItemId). and(_.UnitId eqs UnitId).one()
  }

  def getAllItemUnits: Future[Seq[ItemUnit]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getIItemUnit(ItemId: String, UnitId: String): Future[Seq[ItemUnit]] = {
    select.where(_.ItemId eqs ItemId). and(_.UnitId eqs UnitId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ItemId: String, UnitId: String): Future[ResultSet] = {
    delete.where(_.ItemId eqs ItemId). and(_.UnitId eqs UnitId).future()
  }
}
