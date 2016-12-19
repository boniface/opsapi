package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.LotGuarantee
import services.Lot.Impl.LotGuaranteeServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotGuaranteeService {
  def createOrUpdate(lotGuarantee: LotGuarantee): Future[ResultSet]

  def getLotGuaranteeById(lotId: String, guaranteeId: String): Future[Option[LotGuarantee]]

  def deleteById(lotId: String, guaranteeId: String): Future[ResultSet]

  def getAllLotGuarantees(): Future[Seq[LotGuarantee]]

}
object LotGuaranteeService{
  def apply: LotGuaranteeService = new LotGuaranteeServiceImpl()
}