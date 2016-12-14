package services.item

import domain.Item.ItemLot
import org.scalatest.FunSuite
import services.Item.ItemLotService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemLotServiceTest extends FunSuite {
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
}
