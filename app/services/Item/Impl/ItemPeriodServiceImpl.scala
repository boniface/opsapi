package services.Item.Impl

import com.websudos.phantom.dsl._
import domain.Item.ItemPeriod
import repositories.Item.ItemPeriodRepository
import services.Item.ItemPeriodService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemPeriodServiceImpl extends ItemPeriodService with Service{
  def createOrUpdate(itemPeriod: ItemPeriod): Future[ResultSet] = {
    ItemPeriodRepository.save(itemPeriod)
  }

  def getItemPeriodById(ItemId: String, PeriodId: String): Future[Option[ItemPeriod]] = {
    ItemPeriodRepository.getItemPeriodById(ItemId, PeriodId)
  }

  def getAllItemPeriods(): Future[Seq[ItemPeriod]] = {
    ItemPeriodRepository.getAllItemPeriods
  }

  def deleteById(ItemId: String, PeriodId: String): Future[ResultSet] = {
    ItemPeriodRepository.deleteById(ItemId, PeriodId)
  }
}
