package repositories.Period

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Period.Period

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/14.
  */
class PeriodRepository extends CassandraTable[PeriodRepository, Period] {

  object startDate extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending
  object endDate extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row): Period = {
    Period(
      startDate(r),
      endDate(r))
  }
}

object PeriodRepository extends PeriodRepository with RootConnector {
  override lazy val tableName = "periods"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(period: Period): Future[ResultSet] = {
    insert
      .value(_.startDate, period.startDate)
      .value(_.endDate, period.endDate)
      .future()
  }

  def getAllPeriods: Future[Seq[Period]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getPeriod(StartDate: String, EndDate: String): Future[Seq[Period]] = {
    select.where(_.startDate eqs StartDate). and(_.endDate eqs EndDate).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(startDate: String): Future[ResultSet] = {
    delete.where(_.startDate eqs startDate).future()
  }

}