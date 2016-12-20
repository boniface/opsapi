package services.Contract.Impl

import com.websudos.phantom.dsl._
import domain.Contract.ContractDocument
import repositories.Contract.ContractDocumentRepository
import services.Contract.ContractDocumentService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ContractDocumentServiceImpl extends ContractDocumentService with Service {
  def createOrUpdate(contractDocument: ContractDocument): Future[ResultSet] = {
    ContractDocumentRepository.save(contractDocument)
  }

  def getContractDocumentById(ContractId: String, DocumentId: String): Future[Option[ContractDocument]] = {
    ContractDocumentRepository.getContractDocumentById(ContractId, DocumentId)
  }

  def getAllContractDocuments(): Future[Seq[ContractDocument]] = {
    ContractDocumentRepository.getContractDocuments
  }

  def deleteById(ContractId: String, DocumentId: String): Future[ResultSet] = {
    ContractDocumentRepository.deleteById(ContractId, DocumentId)
  }
}
