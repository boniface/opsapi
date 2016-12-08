package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.LotGuarantee
import io.netty.util.concurrent.Future
import services.Lot.Impl.LotGuaranteeServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotGuaranteeService {
  def createOrUpdate(lotGuarantee: LotGuarantee): Future[ResultSet]

  def getLotGuaranteeById(id: String): Future[Option[LotGuarantee]]

  def deleteById(id: String): Future[ResultSet]

  def getAllLotGuarantees(): Future[Seq[LotGuarantee]]

}
object LotGuaranteeService{
  def apply: LotGuaranteeService = new LotGuaranteeServiceImpl()
}