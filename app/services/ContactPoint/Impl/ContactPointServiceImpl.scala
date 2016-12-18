package services.ContactPoint.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.ContactPoint
import repositories.ContactPointRepository
import services.ContactPoint.ContactPointService
import services.Service

import scala.concurrent.Future

/**
  * Created by 212026992 on 12/3/2016.
  */
class ContactPointServiceImpl extends ContactPointService with Service{
  override def createOrUpdate(address: ContactPoint): Future[ResultSet] = {
    ContactPointRepository.save(address)
  }

  override def getContactPointById(addressType: String): Future[Option[ContactPoint]] = {
    ContactPointRepository.getContactPointById(addressType)
  }

  override def getContactPoints(addressType: String): Future[Seq[ContactPoint]] = {
    ContactPointRepository.getContactPoints(addressType)
  }
}
