package services.Lot.Impl

import com.websudos.phantom.dsl._
import domain.Lot.LotMinimalStep
import repositories.Lot.LotMinimalStepRepository
import services.Lot.LotMinimalStepService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotMinimalStepServiceImpl extends LotMinimalStepService with Service{
  def createOrUpdate(lotMinimalStep: LotMinimalStep): Future[ResultSet] = {
    LotMinimalStepRepository.save(lotMinimalStep)
  }

  def getLotMinimalStepById(lotId: String, valueId: String): Future[Option[LotMinimalStep]] = {
    LotMinimalStepRepository.getLotMinimalStepById(lotId, valueId)
  }

  def getAllLotMinimalSteps(): Future[Seq[LotMinimalStep]] = {
    LotMinimalStepRepository.getAllLotMinimalSteps
  }

  def deleteById(lotId: String, valueId: String): Future[ResultSet] = {
    LotMinimalStepRepository.deleteById(lotId, valueId)
  }
}
