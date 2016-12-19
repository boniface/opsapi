package services.Item.Impl

import com.websudos.phantom.dsl._
import domain.Item.ItemLot
import repositories.Item.ItemLotRepository
import services.Item.ItemLotService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemLotServiceImpl extends ItemLotService with Service{
  def createOrUpdate(itemLot: ItemLot): Future[ResultSet] = {
    ItemLotRepository.save(itemLot)
  }

  def getItemLotById(itemId: String, lot: String): Future[Option[ItemLot]] = {
    ItemLotRepository.getItemLotById(itemId, lot)
  }

  def getAllItemLots(): Future[Seq[ItemLot]] = {
    ItemLotRepository.getAllItemLots
  }

  def deleteById(itemId: String, lot: String): Future[ResultSet] = {
    ItemLotRepository.deleteById(itemId, lot)
  }
}
