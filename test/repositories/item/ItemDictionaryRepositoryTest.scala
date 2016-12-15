package repositories.item

import Item.ItemDictionary
import conf.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemDictionaryRepository
import services.Item.ItemDictionaryService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemDictionaryRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
     ItemDictionaryRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
     ItemDictionaryRepository.truncate().future()
  }
}
