package services.item

import Item.Item
import org.scalatest.FunSuite
import services.Item.ItemService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val item = Item(
      "1",
      "test",
      10)

    val result = Await.result(ItemService.apply.createOrUpdate(item), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItem") {
    val result = Await.result(ItemService.apply.getItemById("1"), 2.minutes)
    assert(result.head.description === "test")
  }
}
