package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemLot
import io.netty.util.concurrent.Future
import services.Item.Impl.ItemLotServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemLotService {
  def createOrUpdate(itemLot: ItemLot): Future[ResultSet]

  def getItemLotById(id: String): Future[Option[ItemLot]]

  def deleteById(id: String): Future[ResultSet]

  def getAllItemLots(): Future[Seq[ItemLot]]

}
object ItemLotService{
  def apply: ItemLotService = new ItemLotServiceImpl()
}