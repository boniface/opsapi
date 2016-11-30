package repositories.Item

import com.datastax.driver.core.Row
import domain.Item.Dictionary
import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class DictionaryRepository extends CassandraTable[DictionaryRepository, Dictionary]{
  object id  extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending
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

  //override implicit def space: KeySpace = DataConnection.keySpace

 // override implicit def session: Session = DataConnection.session

  def save(sched: Dictionary): Future[ResultSet] = {
    insert
      .value(_.id, sched.id)
      .value(_.latitude, sched.latitude)
      .value(_.longitude, sched.longitude)
      .value(_.elevation, sched.elevation)
      .future()
  }

  def getAllScheduledCourse: Future[Seq[Dictionary]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getScheduledCourseById(id: String): Future[Option[Dictionary]] = {
    select.where(_.id eqs id).one()
  }
}

