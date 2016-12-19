package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.LotPeriod
import services.Lot.Impl.LotPeriodServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotPeriodService {
  def createOrUpdate(lotPeriod: LotPeriod): Future[ResultSet]

  def getLotPeriodById(lotId: String, periodId: String): Future[Option[LotPeriod]]

  def deleteById(lotId: String, periodId: String): Future[ResultSet]

  def getAllLotPeriods(): Future[Seq[LotPeriod]]

}
object LotPeriodService{
  def apply: LotPeriodService = new LotPeriodServiceImpl()
}