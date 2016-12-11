package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemLot
import services.Item.Impl.ItemLotServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemLotService {
  def createOrUpdate(itemLot: ItemLot): Future[ResultSet]

  def getItemLotById(itemId: String, lot: String): Future[Option[ItemLot]]

  def deleteById(itemId: String, lot: String): Future[ResultSet]

  def getAllItemLots(): Future[Seq[ItemLot]]

}
object ItemLotService{
  def apply: ItemLotService = new ItemLotServiceImpl()
}