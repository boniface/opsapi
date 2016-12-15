package repositories.item

import conf.DataConnection
import domain.Item.ItemPeriod
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemPeriodRepository
import services.Item.ItemPeriodService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemPeriodRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ItemPeriodRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {
    val itemPeriod = ItemPeriod(
      "15",
      "22")

    val result = Await.result(ItemPeriodService.apply.createOrUpdate(itemPeriod), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItemPeriod") {
    val result = Await.result(ItemPeriodService.apply.getItemPeriodById("15","22"), 2.minutes)
    assert( result.head.PeriodId === "22")
  }

  override protected def afterEach(): Unit = {
    //Delete All records
    ItemPeriodRepository.truncate().future()
  }
}
