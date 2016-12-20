package repositories.Complaint

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Complaint

import scala.concurrent.Future
/**
  * Created by sanXion on 2016/12/14.
  */
class ComplaintRepository extends CassandraTable[ComplaintRepository, Complaint] {

  object complaintId extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending

  object title extends StringColumn(this)

  object description extends StringColumn(this)

  object date extends DateTimeColumn(this) with PrimaryKey[DateTime] with ClusteringOrder[DateTime] with Descending

  //object dateSubmitted extends StringColumn(this)

  //object dateAnswered extends StringColumn(this)

  //object dateEscalated extends StringColumn(this)

  //object dateDecision extends StringColumn(this)

 // object dateCanceled extends StringColumn(this)

  object status extends StringColumn(this)

  object ttype extends StringColumn(this)

  object resolutionType extends StringColumn(this)

  object satisfied extends BooleanColumn(this)

  object decision extends StringColumn(this)

  object cancellationReason extends StringColumn(this)

  //object relatedLot extends StringColumn(this)

  object tendererAction extends StringColumn(this)

  //object documents extends StringColumn(this)

  //object tendererActionDate extends StringColumn(this)

  override def fromRow(r: Row): Complaint = {
    Complaint(
      complaintId(r),
      title(r),
      description(r),
      date(r),
      status(r),
      ttype(r),
      resolutionType(r),
      satisfied(r),
      decision(r),
      cancellationReason(r),
      tendererAction(r))
  }
}

object ComplaintRepository extends ComplaintRepository with RootConnector {
  override lazy val tableName = "complaints"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(complaint: Complaint): Future[ResultSet] = {
    insert
      .value(_.complaintId, complaint.id)
      .value(_.title, complaint.title)
      .value(_.description, complaint.description)
      .value(_.date, complaint.date)
      .value(_.status, complaint.status)
      .value(_.ttype, complaint.ttype)
      .value(_.resolutionType, complaint.resolutionType)
      .value(_.satisfied, complaint.satisfied)
      .value(_.decision, complaint.decision)
      .value(_.cancellationReason, complaint.cancellationReason)
      .value(_.tendererAction, complaint.tendererAction)
      .future()
  }

  def getComplaintById(ComplaintId: String): Future[Option[Complaint]] = {
    select.where(_.complaintId eqs ComplaintId).one()
  }

  def getAllComplaints: Future[Seq[Complaint]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getComplaint(ComplaintId: String): Future[Seq[Complaint]] = {
    select.where(_.complaintId eqs ComplaintId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ComplaintId: String): Future[ResultSet] = {
    delete.where(_.complaintId eqs ComplaintId).future()
  }

}
