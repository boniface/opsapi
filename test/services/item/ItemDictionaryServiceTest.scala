package services.item

import Item.ItemDictionary
import org.scalatest.FunSuite
import services.Item.ItemDictionaryService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemDictionaryServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val itemDictionary =  ItemDictionary(
      "5",
      "4")

    val result = Await.result(ItemDictionaryService.apply.createOrUpdate(itemDictionary), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGet ItemDictionary") {
    val result = Await.result( ItemDictionaryService.apply.getItemDictionaryById("5","4"), 2.minutes)
    assert( result.head.DictionaryId === "4")
  }
}
