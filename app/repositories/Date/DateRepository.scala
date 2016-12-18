package repositories.Date

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Date.Date

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/14.
  */
class DateRepository extends CassandraTable[DateRepository, Date] {

  object date extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending

  override def fromRow(r: Row): Date = {
    Date(
      date(r))
  }
}

object DateRepository extends DateRepository with RootConnector {
  override lazy val tableName = "dates"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(date: Date): Future[ResultSet] = {
    insert
      .value(_.date, date.date)
      .future()
  }

  def getAllDates: Future[Seq[Date]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getDate(date: String): Future[Seq[Date]] = {
    select.where(_.date eqs date).fetchEnumerator() run Iteratee.collect()
  }

  def deleteByDate(date: String): Future[ResultSet] = {
    delete.where(_.date eqs date).future()
  }

}