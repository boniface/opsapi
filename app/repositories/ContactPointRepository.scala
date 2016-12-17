package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.connection.DataConnection
import domain.ContactPoint

import scala.concurrent.Future
/**
  * Created by 212026992 on 12/3/2016.
  */
sealed class ContactPointRepository extends CassandraTable[ContactPointRepository,ContactPoint]{
  object name extends StringColumn(this) with PartitionKey[String]
  object email extends StringColumn(this)
  object telephone extends StringColumn(this)
  object faxNumber extends StringColumn(this)
  object url extends StringColumn(this)

  override def fromRow(r: Row): ContactPoint = {
    ContactPoint(name(r),email(r)
      ,telephone(r)
      ,faxNumber(r)
      ,url(r))
  }
}


object ContactPointRepository extends ContactPointRepository with RootConnector {
  override lazy val tableName = "ContactPoint"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contactPoint: ContactPoint): Future[ResultSet] = {
    insert
      .value(_.name, contactPoint.name)
      .value(_.email, contactPoint.email)
      .value(_.telephone, contactPoint.telephone)
      .value(_.faxNumber, contactPoint.faxNumber)
      .value(_.url, contactPoint.url)
      .future()
  }

  def getContactPointById(name: String):Future[Option[ContactPoint]] = {
    select.where(_.name eqs name).one()
  }
  def getContactPoints(name:String): Future[Seq[ContactPoint]] = {
    select.where(_.name eqs name).fetchEnumerator() run Iteratee.collect()
  }
  def getContactPoint(name: String): Future[Seq[ContactPoint]] = {
    select.where(_.name eqs name).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(name:String): Future[ResultSet] = {
    delete.where(_.name eqs name).future()
  }
}
