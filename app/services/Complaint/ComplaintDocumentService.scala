package services.Complaint

import com.websudos.phantom.dsl._
import domain.Complaint.ComplaintDocument

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ComplaintDocumentService {
  def createOrUpdate(complaintDocument: ComplaintDocument): Future[ResultSet]

  def getComplaintDocumentById(complaintId: String, document: String): Future[Option[ComplaintDocument]]

  def deleteById(complaintId: String, document: String): Future[ResultSet]

  def getAllComplaintDocuments(): Future[Seq[ComplaintDocument]]

}
object ComplaintDocumentService{
  def apply: ComplaintDocumentService = new ComplaintDocumentServiceImpl()
}
