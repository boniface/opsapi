package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.LotValues
import services.Lot.Impl.LotValuesServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotValuesService {
  def createOrUpdate(lotValues: LotValues): Future[ResultSet]

  def getLotValuesById(lotId: String, valueId: String): Future[Option[LotValues]]

  def deleteById(lotId: String, valueId: String): Future[ResultSet]

  def getAllLotValues(): Future[Seq[LotValues]]

}
object LotValuesService{
  def apply: LotValuesService = new LotValuesServiceImpl()
}