package repositories.Lot

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Lot.LotValues

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotValuesRepository extends CassandraTable[LotValuesRepository,  LotValues]{
  object  LotId extends StringColumn(this) with PartitionKey[String]
  object ValueId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row): LotValues = {
     LotValues(
      LotId(r),
      ValueId(r))
  }

}

object LotValuesRepository extends LotValuesRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(lotValues:  LotValues): Future[ResultSet] = {
    insert
      .value(_.LotId,lotValues.LotId)
      .value(_.ValueId,lotValues.ValueId)
      .future()
  }

  def getLotValuesById( LotId: String, ValueId: String): Future[Option[ LotValues]] = {
    select.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).one()
  }

  def getAllLotValuess: Future[Seq[ LotValues]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getLotValues( LotId: String, ValueId: String): Future[Seq[ LotValues]] = {
    select.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById( LotId: String, ValueId: String): Future[ResultSet] = {
    delete.where(_.LotId eqs  LotId). and(_.ValueId eqs ValueId).future()
  }
}