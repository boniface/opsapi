package services.Organization

import com.websudos.phantom.dsl._
import io.netty.util.concurrent.Future

import services.Organization.Impl.OrganizationServiceImpl
import domain.Organization
/**
  * Created by 212026992 on 12/9/2016.
  */
  trait OrganizationService {
  def createOrUpdate(identifier: Organization): Future[ResultSet]

  def getOrganizationById(id: String): Future[Option[Organization]]

  def deleteById(id: String): Future[ResultSet]

  def getAllOrganization(): Future[Seq[Organization]]

}
object OrganizationService{
  def apply: OrganizationService = new OrganizationServiceImpl()


}
