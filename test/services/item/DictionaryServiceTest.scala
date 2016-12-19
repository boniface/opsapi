package services.item

import domain.Item.Dictionary
import org.scalatest.FunSuite
import services.Item.DictionaryService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class DictionaryServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val dictionary = Dictionary(
      "2",
      "test",
      "test",
      "test")

    val result = Await.result(DictionaryService.apply.createOrUpdate(dictionary), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetDictionary") {
    val result = Await.result(DictionaryService.apply.getDictionaryById("2"), 2.minutes)
    assert( result.head.elevation === "test")
  }
}
