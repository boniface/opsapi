package services.item

import domain.Item.ItemAdditionalClassifications
import org.scalatest.FunSuite
import services.Item.ItemAdditionalClassificationsService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAdditionalClassificationsServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val itemAdditionalClassifications = ItemAdditionalClassifications(
      "4",
      "8")

    val result = Await.result(ItemAdditionalClassificationsService.apply.createOrUpdate(itemAdditionalClassifications), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItemAdditionalClassifications") {
    val result = Await.result(ItemAdditionalClassificationsService.apply.getItemAdditionalClassificationsById("4","8"), 2.minutes)
    assert( result.head.ItemId === "4")
  }
}
