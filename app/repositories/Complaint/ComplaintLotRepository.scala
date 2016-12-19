package repositories.Complaint

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Complaint.ComplaintLot

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ComplaintLotRepository extends CassandraTable[ComplaintLotRepository, ComplaintLot]{

  object complaintId extends StringColumn(this) with PartitionKey[String]

  object lotId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ComplaintLot = {
    ComplaintLot(
      complaintId(r),
      lotId(r))
  }
}

object ComplaintLotRepository extends ComplaintLotRepository with RootConnector {
  override lazy val tableName = "complaintLots"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(complaintLot: ComplaintLot): Future[ResultSet] = {
    insert
      .value(_.complaintId, complaintLot.ComplaintId)
      .value(_.lotId, complaintLot.LotId)
      .future()
  }

  def getComplaintLotById(ComplaintId: String, LotId: String): Future[Option[ComplaintLot]] = {
    select.where(_.complaintId eqs ComplaintId). and(_.lotId eqs LotId).one()
  }

  def getAllComplaintLots: Future[Seq[ComplaintLot]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getComplaintLot(ComplaintId: String, LotId: String): Future[Seq[ComplaintLot]] = {
    select.where(_.complaintId eqs ComplaintId). and(_.lotId eqs LotId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ComplaintId: String, LotId: String): Future[ResultSet] = {
    delete.where(_.complaintId eqs ComplaintId). and(_.lotId eqs LotId).future()
  }
}
