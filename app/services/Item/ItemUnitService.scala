package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemUnit
import io.netty.util.concurrent.Future
import services.Item.Impl.ItemUnitServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemUnitService {
  def createOrUpdate(itemUnit: ItemUnit): Future[ResultSet]

  def getItemUnitById(id: String): Future[Option[ItemUnit]]

  def deleteById(id: String): Future[ResultSet]

  def getAllItemUnits(): Future[Seq[ItemUnit]]

}
object ItemUnitService{
  def apply: ItemUnitService = new ItemUnitServiceImpl()
}