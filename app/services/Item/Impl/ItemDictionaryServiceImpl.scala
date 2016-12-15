package services.Item.Impl

import Item.ItemDictionary
import com.websudos.phantom.dsl._
import repositories.Item.ItemDictionaryRepository
import services.Item.ItemDictionaryService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemDictionaryServiceImpl extends ItemDictionaryService with Service{
  def createOrUpdate(itemDictionary: ItemDictionary): Future[ResultSet] = {
    ItemDictionaryRepository.save(itemDictionary)
  }

  def getItemDictionaryById(itemId: String,Dictionary: String): Future[Option[ItemDictionary]] = {
    ItemDictionaryRepository.getItemDictionaryById(itemId,Dictionary)
  }

  def getAllItemDictionaries(): Future[Seq[ItemDictionary]] = {
    ItemDictionaryRepository.getAllItemDictionaries
  }

  def deleteById(itemId: String,Dictionary: String): Future[ResultSet] = {
    ItemDictionaryRepository.deleteById(itemId,Dictionary)
  }
}
