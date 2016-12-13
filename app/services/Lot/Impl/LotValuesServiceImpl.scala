package services.Lot.Impl

import com.websudos.phantom.dsl._
import domain.Lot.LotValues
import repositories.Lot.LotValuesRepository
import services.Lot.LotValuesService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotValuesServiceImpl extends  LotValuesService with Service{
  def createOrUpdate(lotValues:  LotValues): Future[ResultSet] = {
     LotValuesRepository.save(lotValues)
  }

  def getLotValuesById(lotId: String, valueId: String): Future[Option[ LotValues]] = {
     LotValuesRepository.getLotValuesById(lotId, valueId)
  }

  def getAllLotValues(): Future[Seq[ LotValues]] = {
     LotValuesRepository.getAllLotValuess
  }

  def deleteById(lotId: String, valueId: String): Future[ResultSet] = {
     LotValuesRepository.deleteById(lotId, valueId)
  }
}
