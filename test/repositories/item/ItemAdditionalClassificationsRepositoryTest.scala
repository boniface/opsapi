package repositories.item

import conf.DataConnection
import domain.Item.ItemAdditionalClassifications
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemAdditionalClassificationsRepository
import services.Item.ItemAdditionalClassificationsService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAdditionalClassificationsRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
     ItemAdditionalClassificationsRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
     ItemAdditionalClassificationsRepository.truncate().future()
  }
}
