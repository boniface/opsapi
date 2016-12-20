package services.Complaint.Impl

import com.websudos.phantom.dsl._
import domain.Complaint.ComplaintOrganization
import repositories.Complaint.ComplaintOrganizationRepository
import services.Complaint.ComplaintOrganizationService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ComplaintOrganizationServiceImpl extends ComplaintOrganizationService with Service {
  def createOrUpdate(complaintOrganization: ComplaintOrganization): Future[ResultSet] = {
    ComplaintOrganizationRepository.save(complaintOrganization)
  }

  def getComplaintOrganizationById(ComplaintId: String, OrganizationId: String): Future[Option[ComplaintOrganization]] = {
    ComplaintOrganizationRepository.getComplaintOrganizationById(ComplaintId, OrganizationId)
  }

  def getAllComplaintOrganizations(): Future[Seq[ComplaintOrganization]] = {
    ComplaintOrganizationRepository.getAllComplaintOrganizations
  }

  def deleteById(ComplaintId: String, OrganizationId: String): Future[ResultSet] = {
    ComplaintOrganizationRepository.deleteById(ComplaintId, OrganizationId)
  }
}