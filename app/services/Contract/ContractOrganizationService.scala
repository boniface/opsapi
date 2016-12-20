package services.Contract

import com.websudos.phantom.dsl._
import domain.Contract.ContractOrganization

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ContractOrganizationService {
  def createOrUpdate(contractOrganization: ContractOrganization): Future[ResultSet]

  def getContractOrganizationById(contractId: String, organization: String): Future[Option[ContractOrganization]]

  def deleteById(contractId: String, organization: String): Future[ResultSet]

  def getAllContractOrganizations(): Future[Seq[ContractOrganization]]

}
object ContractOrganizationService{
  def apply: ContractOrganizationService = new ContractOrganizationServiceImpl()
}