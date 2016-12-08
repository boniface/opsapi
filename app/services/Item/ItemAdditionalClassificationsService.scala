package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemAdditionalClassifications
import io.netty.util.concurrent.Future
import services.Item.Impl.ItemAdditionalClassificationsServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemAdditionalClassificationsService {
  def createOrUpdate(itemAdditionalClassifications: ItemAdditionalClassifications): Future[ResultSet]

  def getItemAdditionalClassificationsById(id: String): Future[Option[ItemAdditionalClassifications]]

  def deleteById(id: String): Future[ResultSet]

  def getAllItemAdditionalClassificationss(): Future[Seq[ItemAdditionalClassifications]]

}
object ItemAdditionalClassificationsService{
  def apply: ItemAdditionalClassificationsService = new ItemAdditionalClassificationsServiceImpl()
}