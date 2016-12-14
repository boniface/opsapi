package services.ContactPoint.Impl
import com.websudos.phantom.dsl._
import domain.ContactPoint
import repositories.ContactPointRepository
import services.ContactPoint.ContactPointService
import services.Service
import scala.concurrent.Future


/**
  * Created by 212026992 on 12/14/2016.
  */
class ContactPointServiceImpl extends ContactPointService with Service{



  override def createOrUpdate(contactPoint: ContactPoint): Future[ResultSet] = {
    ContactPointRepository.save(contactPoint)
  }

  def getAddressById(id: String): Future[Option[ContactPoint]] = {
    ContactPointRepository.getContactPointById(id)
  }

  def getAllAddress(): Future[Seq[ContactPoint]] = {
    ContactPointRepository.getAllContactPoint
  }

  def deleteById(id: String): Future[ResultSet] = {
    ContactPointRepository.deleteById(id)
  }
}
