package repositories.Lot

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Lot.LotPeriod

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotPeriodRepository extends CassandraTable[LotPeriodRepository, LotPeriod]{
  object  LotId extends StringColumn(this) with PartitionKey[String]
  object PeriodId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):LotPeriod = {
    LotPeriod(
      LotId(r),
      PeriodId(r))
  }

}

object LotPeriodRepository extends LotPeriodRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(lotPeriod: LotPeriod): Future[ResultSet] = {
    insert
      .value(_.LotId,lotPeriod.LotId)
      .value(_.PeriodId,lotPeriod.PeriodId)
      .future()
  }

  def getLotPeriodById( LotId: String, PeriodId: String): Future[Option[LotPeriod]] = {
    select.where(_.LotId eqs  LotId). and(_.PeriodId eqs PeriodId).one()
  }

  def getAllLotPeriods: Future[Seq[LotPeriod]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getLotPeriod( LotId: String, PeriodId: String): Future[Seq[LotPeriod]] = {
    select.where(_.LotId eqs  LotId). and(_.PeriodId eqs PeriodId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById( LotId: String, PeriodId: String): Future[ResultSet] = {
    delete.where(_.LotId eqs  LotId). and(_.PeriodId eqs PeriodId).future()
  }
}