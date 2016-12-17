package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.connection.DataConnection
import domain.{Address, Title}

import scala.concurrent.Future
/**
  * Created by 212026992 on 12/4/2016.
  */
sealed class TitleRepository  extends CassandraTable[TitleRepository, Title]{

  object tenderCode extends StringColumn(this)with PartitionKey[String]
  object periodicityOfTheTender extends StringColumn(this)
  object itemBeingProcured extends StringColumn(this)


  override def fromRow(r: Row): Title={
    Title(
      tenderCode(r),
      periodicityOfTheTender(r),
      itemBeingProcured(r))

  }
}

object TitleRepository extends TitleRepository with RootConnector {
  override lazy val tableName = "Title"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session


  def save(title: Title): Future[ResultSet] = {
    insert
      .value(_.tenderCode, title.tenderCode)
      .value(_.periodicityOfTheTender, title.periodicityOfTheTender)
      .value(_.itemBeingProcured, title.itemBeingProcured)
      .future()
  }

  def getTitleById(id: String):Future[Option[Title]] = {
    select.where(_.tenderCode eqs id).one()
  }
  def getTitles(id:String): Future[Seq[Title]] = {
    select.where(_.tenderCode eqs id).fetchEnumerator() run Iteratee.collect()
  }
  def geTitle(id: String): Future[Seq[Title]] = {
    select.where(_.tenderCode eqs id).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(id:String): Future[ResultSet] = {
    delete.where(_.tenderCode eqs id).future()
  }
}

