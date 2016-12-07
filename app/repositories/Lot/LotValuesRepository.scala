package repositories.Lot

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.connection.DataConnection
import domain.Lot.LotValue

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotValueRepository extends CassandraTable[LotValueRepository,  LotValue]{
  object  LotId extends StringColumn(this) with PartitionKey[String]
  object ValueId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row): LotValue = {
     LotValue(
      LotId(r),
      ValueId(r))
  }

}

object LotValueRepository extends LotValueRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(lotValue:  LotValue): Future[ResultSet] = {
    insert
      .value(_.LotId,lotValue.LotId)
      .value(_.ValueId,lotValue.ValueId)
      .future()
  }

  def getLotMinimalStepById( LotId: String, ValueId: String): Future[Option[ LotValue]] = {
    select.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).one()
  }

  def getAllLotMinimalSteps: Future[Seq[ LotValue]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getLotMinimalStep( LotId: String, ValueId: String): Future[Seq[ LotValue]] = {
    select.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById( LotId: String, ValueId: String): Future[ResultSet] = {
    delete.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).future()
  }
}