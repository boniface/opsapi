package repositories.Item

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Item.ItemAdditionalClassifications

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemAdditionalClassificationsRepository extends CassandraTable[ItemAdditionalClassificationsRepository, ItemAdditionalClassifications]{
  object itemId extends StringColumn(this) with PartitionKey[String]
  object classificationsId extends StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row): ItemAdditionalClassifications = {
    ItemAdditionalClassifications(
      itemId(r),
      classificationsId(r)
    )
  }
}

object ItemAdditionalClassificationsRepository extends ItemAdditionalClassificationsRepository  with RootConnector {
  override lazy val tableName = "courserating"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(itemAdditionalClassifications: ItemAdditionalClassifications): Future[ResultSet] = {
    insert
      .value(_.itemId, itemAdditionalClassifications.ItemId)
      .value(_.classificationsId, itemAdditionalClassifications.ClassificationsId)
      .future()
  }

  def getItemAdditionalClassificationsById(itemId: String, classificationsId:String):Future[Option[ ItemAdditionalClassifications]] = {
    select.where(_.itemId eqs itemId). and(_.classificationsId eqs classificationsId).one()
  }
  def getAllItemAdditionalClassifications: Future[Seq[ ItemAdditionalClassifications]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
  def getItemAdditionalClassifications(itemId: String): Future[Seq[ ItemAdditionalClassifications]] = {
    select.where(_.itemId eqs itemId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(itemId:String, classificationsId:String): Future[ResultSet] = {
    delete.where(_.itemId eqs itemId). and(_.classificationsId eqs classificationsId).future()
  }
}