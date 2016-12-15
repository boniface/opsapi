package repositories.Item

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Item.Dictionary

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class DictionaryRepository extends CassandraTable[DictionaryRepository, Dictionary]{
  object id  extends StringColumn(this) with PrimaryKey[String]
  object latitude extends StringColumn(this)
  object longitude extends StringColumn(this)
  object elevation extends StringColumn(this)

  override def fromRow(r: Row):Dictionary = {
      Dictionary(
       id (r),
       latitude (r),
       longitude (r),
       elevation (r)
    )

  }

}

object DictionaryRepository extends DictionaryRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(dictionary: Dictionary): Future[ResultSet] = {
    insert
      .value(_.id, dictionary.id)
      .value(_.latitude, dictionary.latitude)
      .value(_.longitude, dictionary.longitude)
      .value(_.elevation, dictionary.elevation)
      .future()
  }

  def getDictionaryById(id: String):Future[Option[Dictionary]] = {
    select.where(_.id eqs id).one()
  }
  def getAllDictionaries: Future[Seq[Dictionary]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
  def getDictionary(id: String): Future[Seq[Dictionary]] = {
    select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(id:String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }

}

