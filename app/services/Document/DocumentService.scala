package services.Document

import com.websudos.phantom.dsl._
import domain.Document.Document
import services.Document.Impl.DocumentServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait DocumentService {
  def createOrUpdate(document: Document): Future[ResultSet]

  def getDocumentById(id: String): Future[Option[Document]]

  def deleteById(id: String): Future[ResultSet]

  def getAllDocuments(): Future[Seq[Document]]

}
object DocumentService{
  def apply: DocumentService = new DocumentServiceImpl()
}