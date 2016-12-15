package repositories.Item

import Item.ItemClassification
import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemClassificationRepository extends CassandraTable[ItemClassificationRepository, ItemClassification]{
  object ItemId extends StringColumn(this) with PartitionKey[String]
  object ClassificationId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ItemClassification = {
    ItemClassification(
      ItemId(r),
      ClassificationId(r))
  }

}

object ItemClassificationRepository extends ItemClassificationRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(itemClassification: ItemClassification): Future[ResultSet] = {
    insert
      .value(_.ItemId, itemClassification.ItemId)
      .value(_.ClassificationId, itemClassification.ClassificationId)
      .future()
  }

  def getItemClassificationById(ItemId: String, ClassificationId: String): Future[Option[ItemClassification]] = {
    select.where(_.ItemId eqs ItemId). and(_.ClassificationId eqs ClassificationId).one()
  }

  def getAllItemClassifications: Future[Seq[ItemClassification]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getItemClassification(ItemId: String, ClassificationId: String): Future[Seq[ItemClassification]] = {
    select.where(_.ItemId eqs ItemId). and(_.ClassificationId eqs ClassificationId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ItemId: String, ClassificationId: String): Future[ResultSet] = {
    delete.where(_.ItemId eqs ItemId). and(_.ClassificationId eqs ClassificationId).future()
  }
}
