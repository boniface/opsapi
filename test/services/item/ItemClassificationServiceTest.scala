package services.item

import Item.ItemClassification
import org.scalatest.FunSuite
import services.Item.ItemClassificationService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemClassificationServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val itemClassification = ItemClassification(
      "4",
      "3")

    val result = Await.result(ItemClassificationService.apply.createOrUpdate(itemClassification), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItemClassification") {
    val result = Await.result(ItemClassificationService.apply.getItemClassificationById("4","3"), 2.minutes)
    assert( result.head.ClassificationId === "3")
  }
}
