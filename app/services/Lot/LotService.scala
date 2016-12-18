package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.Lot
import services.Lot.Impl.LotServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotService {
  def createOrUpdate(lot: Lot): Future[ResultSet]

  def getLotById(id: String): Future[Option[Lot]]

  def deleteById(id: String): Future[ResultSet]

  def getAllLots(): Future[Seq[Lot]]

}
object LotService{
  def apply: LotService = new LotServiceImpl()
}