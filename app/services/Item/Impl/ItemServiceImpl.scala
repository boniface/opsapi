package services.Item.Impl

import Item.Item
import com.websudos.phantom.dsl._
import repositories.Item.ItemRepository
import services.Item.ItemService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemServiceImpl extends ItemService with Service{
  def createOrUpdate(document: Item): Future[ResultSet] = {
    ItemRepository.save(document)
  }

  def getItemById(id: String): Future[Option[Item]] = {
    ItemRepository.getItemById(id)
  }

  def getAllItems(): Future[Seq[Item]] = {
    ItemRepository.getAllItems
  }

  def deleteById(id: String): Future[ResultSet] = {
    ItemRepository.deleteById(id)
  }
}
