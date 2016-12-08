package services.Document.Impl

import com.websudos.phantom.dsl._
import domain.Document.Document
import repositories.Document.DocumentRepository
import services.Document.DocumentService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class DocumentServiceImpl extends DocumentService with Service{
  def createOrUpdate(document: Document): Future[ResultSet] = {
    DocumentRepository.save(document)
  }

  def getDocumentById(id: String): Future[Option[Document]] = {
    DocumentRepository.getDocumentById(id)
  }

  def getAllDocuments(): Future[Seq[Document]] = {
    DocumentRepository.getAllDocuments
  }

  def deleteById(id: String): Future[ResultSet] = {
    DocumentRepository.deleteById(id)
  }
}