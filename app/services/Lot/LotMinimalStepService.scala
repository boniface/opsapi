package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.LotMinimalStep
import services.Lot.Impl.LotMinimalStepServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotMinimalStepService {
  def createOrUpdate(lotMinimalStep: LotMinimalStep): Future[ResultSet]

  def getLotMinimalStepById(lotId: String, valueId: String): Future[Option[LotMinimalStep]]

  def deleteById(lotId: String, valueId: String): Future[ResultSet]

  def getAllLotMinimalSteps(): Future[Seq[LotMinimalStep]]

}
object LotMinimalStepService{
  def apply: LotMinimalStepService = new LotMinimalStepServiceImpl()
}