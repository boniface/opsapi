package repositories.Unit

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Unit.Unit

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class UnitRepository extends CassandraTable[UnitRepository, Unit]{
  object code extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending
  object name extends  StringColumn(this)


  override def fromRow(r: Row):Unit = {
    Unit(
      code(r),
      name(r)
    )
  }
}

object UnitRepository extends UnitRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(unit: Unit): Future[ResultSet] = {
    insert
      .value(_.code, unit.code)
      .value(_.name, unit.name)
      .future()
  }

  def getUnitById(code: String): Future[Option[Unit]] = {
    select.where(_.code eqs code).one()
  }

  def getAllUnits: Future[Seq[Unit]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getUnit(code: String): Future[Seq[Unit]] = {
    select.where(_.code eqs code).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(code: String): Future[ResultSet] = {
    delete.where(_.code eqs code).future()
  }
}