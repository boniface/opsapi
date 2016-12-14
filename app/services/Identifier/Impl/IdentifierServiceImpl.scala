package services.Identifier.Impl

import domain.Identifier
import repositories.IdentifierRepository
import services.Identifier.IdentifierService
import services.Service
import com.websudos.phantom.dsl._
import scala.concurrent.Future
/**
  * Created by 212026992 on 12/9/2016.
  */
class IdentifierServiceImpl extends IdentifierService with Service{



  override def createOrUpdate(identifier: Identifier): Future[ResultSet] = {
    IdentifierRepository.save(identifier)
  }

  def getIdentifierById(id: String): Future[Option[Identifier]] = {
    IdentifierRepository.getContactPointById(id)
  }

  def getAllIdentifier(): Future[Seq[Identifier]] = {
    IdentifierRepository.getAllContactPoint
  }

  def deleteById(id: String): Future[ResultSet] = {
    IdentifierRepository.deleteById(id)
  }
}