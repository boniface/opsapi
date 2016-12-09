package services.Lot.Impl

import com.websudos.phantom.dsl._
import domain.Lot.LotGuarantee
import repositories.Lot.LotGuaranteeRepository
import services.Lot.LotGuaranteeService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class LotGuaranteeServiceImpl extends LotGuaranteeService with Service{
  def createOrUpdate(lotGuarantee: LotGuarantee): Future[ResultSet] = {
    LotGuaranteeRepository.save(lotGuarantee)
  }

  def getLotGuaranteeById(lotId: String, guaranteeId: String): Future[Option[LotGuarantee]] = {
    LotGuaranteeRepository.getLotGuaranteeById(lotId, guaranteeId)
  }

  def getAllLotGuarantees(): Future[Seq[LotGuarantee]] = {
    LotGuaranteeRepository.getAllLotGuarantees
  }

  def deleteById(lotId: String, guaranteeId: String): Future[ResultSet] = {
    LotGuaranteeRepository.deleteById(lotId, guaranteeId)
  }
}
