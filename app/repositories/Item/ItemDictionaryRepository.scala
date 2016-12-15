package repositories.Item

import Item.ItemDictionary
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
class ItemDictionaryRepository extends CassandraTable[ItemDictionaryRepository, ItemDictionary]{
  object ItemId extends StringColumn(this) with PrimaryKey[String]
  object DictionaryId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ItemDictionary = {
    ItemDictionary(
      ItemId(r),
      DictionaryId(r))
  }

}

object ItemDictionaryRepository extends ItemDictionaryRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(itemDictionary: ItemDictionary): Future[ResultSet] = {
    insert
      .value(_.ItemId, itemDictionary.ItemId)
      .value(_.DictionaryId, itemDictionary.DictionaryId)
      .future()
  }

  def getItemDictionaryById(ItemId: String, DictionaryId: String): Future[Option[ItemDictionary]] = {
    select.where(_.ItemId eqs ItemId). and(_.DictionaryId eqs DictionaryId).one()
  }

  def getAllItemDictionaries: Future[Seq[ItemDictionary]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getItemDictionary(ItemId: String, DictionaryId: String): Future[Seq[ItemDictionary]] = {
    select.where(_.ItemId eqs ItemId). and(_.DictionaryId eqs DictionaryId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ItemId: String, DictionaryId: String): Future[ResultSet] = {
    delete.where(_.ItemId eqs ItemId). and(_.DictionaryId eqs DictionaryId).future()
  }
}
