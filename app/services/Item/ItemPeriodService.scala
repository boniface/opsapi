package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemPeriod
import io.netty.util.concurrent.Future
import services.Item.Impl.ItemPeriodServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemPeriodService {
  def createOrUpdate(itemPeriod: ItemPeriod): Future[ResultSet]

  def getItemPeriodById(id: String): Future[Option[ItemPeriod]]

  def deleteById(id: String): Future[ResultSet]

  def getAllItemPeriods(): Future[Seq[ItemPeriod]]

}
object ItemPeriodService{
  def apply: ItemPeriodService = new ItemPeriodServiceImpl()
}