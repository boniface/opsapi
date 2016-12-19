package services.Complaint

import com.websudos.phantom.dsl._
import domain.Complaint.ComplaintOrganization

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ComplaintOrganizationService {
  def createOrUpdate(complaintOrganization: ComplaintOrganization): Future[ResultSet]

  def getComplaintOrganizationById(complaintId: String, organization: String): Future[Option[ComplaintOrganization]]

  def deleteById(complaintId: String, organization: String): Future[ResultSet]

  def getAllComplaintOrganizations(): Future[Seq[ComplaintOrganization]]

}
object ComplaintOrganizationService{
  def apply: ComplaintOrganizationService = new ComplaintOrganizationServiceImpl()
}