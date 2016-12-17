package services.Item.Impl

import Item.ItemClassification
import com.websudos.phantom.dsl._
import repositories.Item.ItemClassificationRepository
import services.Item.ItemClassificationService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemClassificationServiceImpl extends ItemClassificationService with Service{
  def createOrUpdate(document: ItemClassification): Future[ResultSet] = {
    ItemClassificationRepository.save(document)
  }

  def getItemClassificationById(ItemId: String, Classification: String): Future[Option[ItemClassification]] = {
    ItemClassificationRepository.getItemClassificationById(ItemId, Classification)
  }

  def getAllItemClassifications(): Future[Seq[ItemClassification]] = {
    ItemClassificationRepository.getAllItemClassifications
  }

  def deleteById(ItemId: String, Classification: String): Future[ResultSet] = {
    ItemClassificationRepository.deleteById(ItemId, Classification)
  }
}
