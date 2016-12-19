package repositories.item

import Item.ItemClassification
import conf.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemClassificationRepository
import services.Item.ItemClassificationService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemClassificationRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ItemClassificationRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
    ItemClassificationRepository.truncate().future()
  }
}
