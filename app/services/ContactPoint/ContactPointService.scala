package services.ContactPoint

import domain.ContactPoint
import com.websudos.phantom.dsl._
import io.netty.util.concurrent.Future
import services.ContactPoint.Impl.ContactPointServiceImpl
/**
  * Created by 212026992 on 12/9/2016.
  */
trait ContactPointService {


  def createOrUpdate(contactPoint: ContactPoint): Future[ResultSet]

  def getAddressById(id: String): Future[Option[ContactPoint]]

  def deleteById(id: String): Future[ResultSet]

  def getAllAddress(): Future[Seq[ContactPoint]]

}
object ContactPointService{
  def apply: ContactPointService = new ContactPointServiceImpl()

}