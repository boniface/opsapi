package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemPeriod
import services.Item.Impl.ItemPeriodServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemPeriodService {
  def createOrUpdate(itemPeriod: ItemPeriod): Future[ResultSet]

  def getItemPeriodById(ItemId: String, PeriodId: String): Future[Option[ItemPeriod]]

  def deleteById(ItemId: String, PeriodId: String): Future[ResultSet]

  def getAllItemPeriods(): Future[Seq[ItemPeriod]]

}
object ItemPeriodService{
  def apply: ItemPeriodService = new ItemPeriodServiceImpl()
}