package services.ContactPoint

import com.websudos.phantom.dsl._
import domain.ContactPoint
import services.ContactPoint.Impl.ContactPointServiceImpl


import scala.concurrent.Future
/**
  * Created by 212026992 on 12/3/2016.
  */
trait ContactPointService {
  def createOrUpdate(addressType:ContactPoint):Future[ResultSet]

  def getContactPointById(addressType: String): Future[Option[ContactPoint]]

  def getContactPoints(addressType: String): Future[Seq[ContactPoint]]
}

object ContactPointService{
  def apply: ContactPointService = new ContactPointServiceImpl()
}