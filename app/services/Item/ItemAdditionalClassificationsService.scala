package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemAdditionalClassifications
import services.Item.Impl.ItemAdditionalClassificationsServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemAdditionalClassificationsService {
  def createOrUpdate(itemAdditionalClassifications: ItemAdditionalClassifications): Future[ResultSet]

  def getItemAdditionalClassificationsById(itemId: String, ClassificationId: String): Future[Option[ItemAdditionalClassifications]]

  def deleteById(itemId: String, ClassificationId: String): Future[ResultSet]

  def getAllItemAdditionalClassifications(): Future[Seq[ItemAdditionalClassifications]]

}
object ItemAdditionalClassificationsService{
  def apply: ItemAdditionalClassificationsService = new ItemAdditionalClassificationsServiceImpl()
}