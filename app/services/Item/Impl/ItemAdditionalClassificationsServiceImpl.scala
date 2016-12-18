package services.Item.Impl

import com.websudos.phantom.dsl._
import domain.Item.ItemAdditionalClassifications
import repositories.Item.ItemAdditionalClassificationsRepository
import services.Item.ItemAdditionalClassificationsService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemAdditionalClassificationsServiceImpl extends ItemAdditionalClassificationsService with Service{
  def createOrUpdate(itemAdditionalClassifications: ItemAdditionalClassifications): Future[ResultSet] = {
    ItemAdditionalClassificationsRepository.save(itemAdditionalClassifications)
  }

  def getItemAdditionalClassificationsById(itemId: String, ClassificationId: String): Future[Option[ItemAdditionalClassifications]] = {
    ItemAdditionalClassificationsRepository.getItemAdditionalClassificationsById(itemId,ClassificationId)
  }

  def getAllItemAdditionalClassifications(): Future[Seq[ItemAdditionalClassifications]] = {
    ItemAdditionalClassificationsRepository.getAllItemAdditionalClassifications
  }

  def deleteById(itemId: String, ClassificationId: String): Future[ResultSet] = {
    ItemAdditionalClassificationsRepository.deleteById(itemId,ClassificationId)
  }

}
