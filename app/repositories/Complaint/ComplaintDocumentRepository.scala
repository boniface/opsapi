package repositories.Complaint
import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Complaint.ComplaintDocument

import scala.concurrent.Future


/**
  * Created by sanXion on 2016/12/18.
  */
class ComplaintDocumentRepository extends CassandraTable[ComplaintDocumentRepository, ComplaintDocument]{

  object complaintId extends StringColumn(this) with PartitionKey[String]

  object documentId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ComplaintDocument = {
    ComplaintDocument(
      complaintId(r),
      documentId(r))
  }
}

object ComplaintDocumentRepository extends ComplaintDocumentRepository with RootConnector {
  override lazy val tableName = "complaintDocuments"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(complaintDocument: ComplaintDocument): Future[ResultSet] = {
    insert
      .value(_.complaintId, complaintDocument.ComplaintId)
      .value(_.documentId, complaintDocument.DocumentId)
      .future()
  }

  def getComplaintDocumentById(ComplaintId: String, DocumentId: String): Future[Option[ComplaintDocument]] = {
    select.where(_.complaintId eqs ComplaintId). and(_.documentId eqs DocumentId).one()
  }

  def getComplaintDocuments: Future[Seq[ComplaintDocument]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getComplaintDocument(ComplaintId: String, DocumentId: String): Future[Seq[ComplaintDocument]] = {
    select.where(_.complaintId eqs ComplaintId). and(_.documentId eqs DocumentId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ComplaintId: String, DocumentId: String): Future[ResultSet] = {
    delete.where(_.complaintId eqs ComplaintId). and(_.documentId eqs DocumentId).future()
  }
}
