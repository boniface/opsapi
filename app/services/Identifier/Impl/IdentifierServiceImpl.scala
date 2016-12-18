package services.Identifier.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.Identifier
import repositories.IdentifierRepository
import services.Identifier.IdentifierService
import services.Service

import scala.concurrent.Future

/**
  * Created by 212026992 on 2016/11/02.
  */
class IdentifierServiceImpl extends IdentifierService with Service{
  override def createOrUpdate(identifier: Identifier): Future[ResultSet] = {
    IdentifierRepository.save(identifier)
  }

  override def getIdentifierById(identifier: String): Future[Option[Identifier]] = {
    IdentifierRepository.getIdentifierById(identifier)
  }

  override def getIdentifiers(identifier: String): Future[Seq[Identifier]] = {
    IdentifierRepository.getIdentifiers(identifier)
  }
}
