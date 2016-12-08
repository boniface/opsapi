package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.LotPeriod
import io.netty.util.concurrent.Future
import services.Lot.Impl.LotPeriodServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotPeriodService {
  def createOrUpdate(lotPeriod: LotPeriod): Future[ResultSet]

  def getLotPeriodById(id: String): Future[Option[LotPeriod]]

  def deleteById(id: String): Future[ResultSet]

  def getAllLotPeriods(): Future[Seq[LotPeriod]]

}
object LotPeriodService{
  def apply: LotPeriodService = new LotPeriodServiceImpl()
}