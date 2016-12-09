package services.Lot.Impl

import com.websudos.phantom.dsl._
import domain.Lot.LotPeriod
import repositories.Lot.LotPeriodRepository
import services.Lot.LotPeriodService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotPeriodServiceImpl extends LotPeriodService with Service{
  def createOrUpdate(document: LotPeriod): Future[ResultSet] = {
    LotPeriodRepository.save(document)
  }

  def getLotPeriodById(lotId: String, periodId: String): Future[Option[LotPeriod]] = {
    LotPeriodRepository.getLotPeriodById(lotId, periodId)
  }

  def getAllLotPeriods(): Future[Seq[LotPeriod]] = {
    LotPeriodRepository.getAllLotPeriods
  }

  def deleteById(lotId: String, periodId: String): Future[ResultSet] = {
    LotPeriodRepository.deleteById(lotId, periodId)
  }
}
