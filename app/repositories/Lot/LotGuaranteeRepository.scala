package repositories.Lot

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Lot.LotGuarantee

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotGuaranteeRepository extends CassandraTable[LotGuaranteeRepository, LotGuarantee]{
  object  LotId extends StringColumn(this) with PartitionKey[String]
  object GuaranteeId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):LotGuarantee = {
    LotGuarantee(
       LotId(r),
      GuaranteeId(r))
  }

}

object LotGuaranteeRepository extends LotGuaranteeRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(lotGuarantee: LotGuarantee): Future[ResultSet] = {
    insert
      .value(_.LotId,lotGuarantee.LotId)
      .value(_.GuaranteeId,lotGuarantee.GuaranteeId)
      .future()
  }

  def getLotGuaranteeById( LotId: String, GuaranteeId: String): Future[Option[LotGuarantee]] = {
    select.where(_.LotId eqs  LotId). and(_.GuaranteeId eqs GuaranteeId).one()
  }

  def getAllLotGuarantees: Future[Seq[LotGuarantee]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getLotGuarantee( LotId: String, GuaranteeId: String): Future[Seq[LotGuarantee]] = {
    select.where(_.LotId eqs  LotId). and(_.GuaranteeId eqs GuaranteeId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById( LotId: String, GuaranteeId: String): Future[ResultSet] = {
    delete.where(_.LotId eqs  LotId). and(_.GuaranteeId eqs GuaranteeId).future()
  }
}