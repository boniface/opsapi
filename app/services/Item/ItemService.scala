package services.Item

import Item.Item
import com.websudos.phantom.dsl._
import services.Item.Impl.ItemServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemService {
  def createOrUpdate(item: Item): Future[ResultSet]

  def getItemById(id: String): Future[Option[Item]]

  def deleteById(id: String): Future[ResultSet]

  def getAllItems(): Future[Seq[Item]]

}
object ItemService{
  def apply: ItemService = new ItemServiceImpl()
}