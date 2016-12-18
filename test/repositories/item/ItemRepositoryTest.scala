package repositories.item

import Item.Item
import conf.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemRepository
import services.Item.ItemService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ItemRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
    ItemRepository.truncate().future()
  }
}
