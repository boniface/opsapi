package repositories.Classification

import com.datastax.driver.core.Row
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Classification.Classification

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class ClassificationRepository extends CassandraTable[ClassificationRepository, Classification]{

  object scheme extends StringColumn(this)
  object id extends StringColumn(this) with PrimaryKey[String]
  object description extends StringColumn(this)
  object uri extends StringColumn(this)

  override def fromRow(r: Row): Classification={
    Classification(
      scheme(r),
      id(r),
      description(r),
      uri(r))
  }
}

object ClassificationRepository extends ClassificationRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session


  def save(classification: Classification): Future[ResultSet] = {
    insert
      .value(_.scheme, classification.scheme)
      .value(_.id, classification.id)
      .value(_.description, classification.description)
      .value(_.uri, classification.uri)
      .future()
  }

  def getClassificationById(id: String):Future[Option[Classification]] = {
    select.where(_.id eqs id).one()
  }
  def getAllClassifications: Future[Seq[Classification]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
  def getClassification(id: String): Future[Seq[Classification]] = {
    select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(id:String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}