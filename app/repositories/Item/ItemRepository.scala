package repositories.Item

import Item.Item
import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemRepository extends CassandraTable[ItemRepository,Item]{
  object ItemId extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending
  object Description extends  StringColumn(this)
  object Quantity  extends  IntColumn(this)


  override def fromRow(r: Row):Item = {
    Item(
      ItemId(r),
      Description(r),
      Quantity(r))
  }

}

object ItemRepository extends ItemRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(item: Item): Future[ResultSet] = {
    insert
      .value(_.ItemId, item.id)
      .value(_.Description, item.description)
      .value(_.Quantity, item.quantity)
      .future()
  }

  def getItemById(ItemId: String): Future[Option[Item]] = {
    select.where(_.ItemId eqs ItemId).one()
  }

  def getAllItems: Future[Seq[Item]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getItem(ItemId: String): Future[Seq[Item]] = {
    select.where(_.ItemId eqs ItemId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ItemId: String): Future[ResultSet] = {
    delete.where(_.ItemId eqs ItemId).future()
  }
}

