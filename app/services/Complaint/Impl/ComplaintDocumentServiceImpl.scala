package services.Complaint.Impl

import com.websudos.phantom.dsl._
import domain.Complaint.ComplaintDocument
import repositories.Complaint.ComplaintDocumentRepository
import services.Complaint.ComplaintDocumentService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ComplaintDocumentServiceImpl extends ComplaintDocumentService with Service {
  def createOrUpdate(complaintDocument: ComplaintDocument): Future[ResultSet] = {
    ComplaintDocumentRepository.save(complaintDocument)
  }

  def getComplaintDocumentById(ComplaintId: String, DocumentId: String): Future[Option[ComplaintDocument]] = {
    ComplaintDocumentRepository.getComplaintDocumentById(ComplaintId, DocumentId)
  }

  def getAllComplaintDocuments(): Future[Seq[ComplaintDocument]] = {
    ComplaintDocumentRepository.getComplaintDocuments
  }

  def deleteById(ComplaintId: String, DocumentId: String): Future[ResultSet] = {
    ComplaintDocumentRepository.deleteById(ComplaintId, DocumentId)
  }
}
