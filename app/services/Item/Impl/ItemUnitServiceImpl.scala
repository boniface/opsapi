package services.Item.Impl

import com.websudos.phantom.dsl._
import domain.Item.ItemUnit
import repositories.Item.ItemUnitRepository
import services.Item.ItemUnitService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemUnitServiceImpl extends ItemUnitService with Service{
  def createOrUpdate(itemUnit: ItemUnit): Future[ResultSet] = {
    ItemUnitRepository.save(itemUnit)
  }

  def getItemUnitById(itemId: String, unit: String): Future[Option[ItemUnit]] = {
    ItemUnitRepository.getItemUnitById(itemId, unit)
  }

  def getAllItemUnits(): Future[Seq[ItemUnit]] = {
    ItemUnitRepository.getAllItemUnits
  }

  def deleteById(itemId: String, unit: String): Future[ResultSet] = {
    ItemUnitRepository.deleteById(itemId, unit)
  }
}
