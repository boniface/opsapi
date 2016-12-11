package services.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.Cancellation
import services.{CancellationService, Service}
import repositories.CancellationRepository

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class CancellationServiceImpl extends CancellationService with Service{
  override def createOrUpdate(cancellation: Cancellation): Future[ResultSet] = {
    CancellationRepository.save(cancellation)
  }

  override def getCancellationById(cancellationId: String): Future[Option[Cancellation]] = {
    CancellationRepository.getCancellationById(cancellationId)
  }

  override def getCancellation(cancellationId: String): Future[Seq[Cancellation]] = {
    CancellationRepository.getCancellationById(cancellationId)
  }

  override def getAllCancellation(): Future[Seq[Cancellation]] = {
    CancellationRepository.findAll()
  }

  override def deleteById(cancellationId: String): Future[Seq[Cancellation]] = {
    CancellationRepository.deleteById()
  }
}
