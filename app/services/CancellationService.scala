package services

import com.websudos.phantom.dsl.ResultSet
import domain.Cancellation
import services.Impl.CancellationServiceImpl

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
trait CancellationService {

  def createOrUpdate(cancellation:Cancellation):Future[ResultSet]

  def getCancellationById(cancellationId: String): Future[Option[Cancellation]]

  def getCancellation(cancellationId: String): Future[Seq[Cancellation]]

  def getAllCancellation(): Future[Seq[Cancellation]]

  def deleteById(cancellationId: String): Future[Seq[Cancellation]]

}

object CancellationService{
  def apply: CancellationService = new CancellationServiceImpl()
}
