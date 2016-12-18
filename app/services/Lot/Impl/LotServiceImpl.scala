package services.Lot.Impl

import com.websudos.phantom.dsl._
import domain.Lot.Lot
import repositories.Lot.LotRepository
import services.Lot.LotService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotServiceImpl extends LotService with Service{
  def createOrUpdate(lot: Lot): Future[ResultSet] = {
    LotRepository.save(lot)
  }

  def getLotById(id: String): Future[Option[Lot]] = {
    LotRepository.getLotById(id)
  }

  def getAllLots(): Future[Seq[Lot]] = {
    LotRepository.getAllLots
  }

  def deleteById(id: String): Future[ResultSet] = {
    LotRepository.deleteById(id)
  }
}
