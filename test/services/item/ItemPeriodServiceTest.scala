package services.item

import domain.Item.ItemPeriod
import org.scalatest.FunSuite
import services.Item.ItemPeriodService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemPeriodServiceTest extends FunSuite {
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
}
