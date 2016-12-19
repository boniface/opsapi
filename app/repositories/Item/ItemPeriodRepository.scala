package repositories.Item

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Item.ItemPeriod

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemPeriodRepository extends CassandraTable[ItemPeriodRepository, ItemPeriod]{
  object ItemId extends StringColumn(this) with PartitionKey[String]
  object PeriodId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ItemPeriod = {
    ItemPeriod(
      ItemId(r),
      PeriodId(r))
  }

}

  object ItemPeriodRepository extends ItemPeriodRepository with RootConnector {
    override lazy val tableName = "schedule"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session

    def save(itemPeriod: ItemPeriod): Future[ResultSet] = {
      insert
        .value(_.ItemId, itemPeriod.ItemId)
        .value(_.PeriodId, itemPeriod.PeriodId)
        .future()
    }

    def getItemPeriodById(ItemId: String, PeriodId: String): Future[Option[ItemPeriod]] = {
      select.where(_.ItemId eqs ItemId). and(_.PeriodId eqs PeriodId).one()
    }

    def getAllItemPeriods: Future[Seq[ItemPeriod]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }

    def getItemPeriod(ItemId: String, PeriodId: String): Future[Seq[ItemPeriod]] = {
      select.where(_.ItemId eqs ItemId). and(_.PeriodId eqs PeriodId).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(ItemId: String, PeriodId: String): Future[ResultSet] = {
      delete.where(_.ItemId eqs ItemId). and(_.PeriodId eqs PeriodId).future()
    }
  }