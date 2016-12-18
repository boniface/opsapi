package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemUnit
import services.Item.Impl.ItemUnitServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemUnitService {
  def createOrUpdate(itemUnit: ItemUnit): Future[ResultSet]

  def getItemUnitById(itemId: String, unit: String): Future[Option[ItemUnit]]

  def deleteById(itemId: String, unit: String): Future[ResultSet]

  def getAllItemUnits(): Future[Seq[ItemUnit]]

}
object ItemUnitService{
  def apply: ItemUnitService = new ItemUnitServiceImpl()
}