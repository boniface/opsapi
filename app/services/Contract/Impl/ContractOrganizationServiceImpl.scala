package services.Contract.Impl

import com.websudos.phantom.dsl._
import domain.Contract.ContractOrganization
import repositories.Contract.ContractOrganizationRepository
import services.Contract.ContractOrganizationService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ContractOrganizationServiceImpl extends ContractOrganizationService with Service {
  def createOrUpdate(contractOrganization: ContractOrganization): Future[ResultSet] = {
    ContractOrganizationRepository.save(contractOrganization)
  }

  def getContractOrganizationById(ContractId: String, OrganizationId: String): Future[Option[ContractOrganization]] = {
    ContractOrganizationRepository.getContractOrganizationById(ContractId, OrganizationId)
  }

  def getAllContractOrganizations(): Future[Seq[ContractOrganization]] = {
    ContractOrganizationRepository.getContractOrganizations
  }

  def deleteById(ContractId: String, OrganizationId: String): Future[ResultSet] = {
    ContractOrganizationRepository.deleteById(ContractId, OrganizationId)
  }
}