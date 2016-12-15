package repositories.Lot

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Lot.LotMinimalStep

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/06.
  */
class LotMinimalStepRepository extends CassandraTable[LotMinimalStepRepository, LotMinimalStep]{
  object  LotId extends StringColumn(this) with PartitionKey[String]
  object ValueId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):LotMinimalStep = {
    LotMinimalStep(
      LotId(r),
      ValueId(r))
  }

}

object LotMinimalStepRepository extends LotMinimalStepRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(lotMinimalStep: LotMinimalStep): Future[ResultSet] = {
    insert
      .value(_.LotId,lotMinimalStep.LotId)
      .value(_.ValueId,lotMinimalStep.ValueId)
      .future()
  }

  def getLotMinimalStepById( LotId: String, ValueId: String): Future[Option[LotMinimalStep]] = {
    select.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).one()
  }

  def getAllLotMinimalSteps: Future[Seq[LotMinimalStep]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getLotMinimalStep( LotId: String, ValueId: String): Future[Seq[LotMinimalStep]] = {
    select.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById( LotId: String, ValueId: String): Future[ResultSet] = {
    delete.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).future()
  }
}