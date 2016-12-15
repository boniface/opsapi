package repositories.item

import conf.DataConnection
import domain.Item.ItemLot
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemLotRepository
import services.Item.ItemLotService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemLotRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
  ItemLotRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {
    val itemLot = ItemLot(
      "4",
      "5")

    val result = Await.result(ItemLotService.apply.createOrUpdate(itemLot), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItemLot") {
    val result = Await.result(ItemLotService.apply.getItemLotById("4","5"), 2.minutes)
    assert( result.head.LotId === "5")
  }

  override protected def afterEach(): Unit = {
    //Delete All records
  ItemLotRepository.truncate().future()
  }
}
