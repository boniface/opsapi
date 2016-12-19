package services.Organization.Impl
import services.Service
import com.websudos.phantom.dsl.ResultSet
import domain.Organization
import repositories.OrganizationRepository
import services.Organization.OrganizationService

import scala.concurrent.Future
/**
  * Created by 212026992 on 12/9/2016.
  */
class OrganizationServiceImpl extends OrganizationService with Service{



  override def createOrUpdate(organization: Organization): Future[ResultSet] = {
    OrganizationRepository.save(organization)
}

  def getOrganizationById(id: String): Future[Option[Organization]] = {
    OrganizationRepository.getOrganizationById(id)
}

  def getAllOrganization(): Future[Seq[Organization]] = {
    OrganizationRepository.getAllOrganization
}

  def deleteById(id: String): Future[ResultSet] = {
    OrganizationRepository.deleteById(id)
}
}
