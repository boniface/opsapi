package services.Contract

import com.websudos.phantom.dsl._
import domain.Contract.ContractDocument

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ContractDocumentService {
  def createOrUpdate(contractDocument: ContractDocument): Future[ResultSet]

  def getContractDocumentById(contractId: String, document: String): Future[Option[ContractDocument]]

  def deleteById(contractId: String, document: String): Future[ResultSet]

  def getAllContractDocuments(): Future[Seq[ContractDocument]]

}
object ContractDocumentService{
  def apply: ContractDocumentService = new ContractDocumentServiceImpl()
}