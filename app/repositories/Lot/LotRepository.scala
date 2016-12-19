package repositories.Lot

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Lot.Lot

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class LotRepository extends CassandraTable[LotRepository, Lot]{
  object id  extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending
  object title extends  StringColumn(this)
  object description extends StringColumn(this)
  object value extends StringColumn(this)
  object guarantee extends StringColumn(this)
  object date extends StringColumn(this)
  object minimalStep extends StringColumn(this)
  object auctionPeriod extends StringColumn(this)
  object auctionUrl extends StringColumn(this)
  object status extends StringColumn(this)

  override def fromRow(r: Row):Lot = {
    Lot(
      id(r),
      title(r),
      description(r),
      //value(r),
     // guarantee(r),
      date(r),
     // minimalStep(r),
      //auctionPeriod(r),
      auctionUrl(r),
      status(r)
    )

  }

}

object LotRepository extends LotRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(lot: Lot): Future[ResultSet] = {
    insert
      .value(_.id, lot.id)
      .value(_.title, lot.title)
      .value(_.description, lot.description)
      //.value(_.value, lot.value)
      //.value(_.guarantee, lot.guarantee)
      .value(_.date, lot.date)
      //.value(_.minimalStep, lot.minimalStep)
     // .value(_.auctionPeriod, lot.auctionPeriod)
      .value(_.auctionUrl, lot.auctionUrl)
      .value(_.status, lot.status)
      .future()
  }

  def getLotById(id: String): Future[Option[Lot]] = {
    select.where(_.id eqs id).one()
  }

  def getAllLots: Future[Seq[Lot]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getLot(id: String): Future[Seq[Lot]] = {
    select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(id: String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}