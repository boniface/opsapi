package services.item

import domain.Item.ItemUnit
import org.scalatest.FunSuite
import services.Item.ItemUnitService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemUnitServiceTest  extends FunSuite {
  test("testSaveOrUpdate") {
    val itemUnit = ItemUnit(
      "18",
      "22")

    val result = Await.result(ItemUnitService.apply.createOrUpdate(itemUnit), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItemUnit") {
    val result = Await.result(ItemUnitService.apply.getItemUnitById("18","22"), 2.minutes)
    assert( result.head.UnitId === "22")
  }
}
