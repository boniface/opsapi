package repositories.item

import conf.DataConnection
import domain.Item.ItemUnit
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemUnitRepository
import services.Item.ItemUnitService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemUnitRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ItemUnitRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {
    val itemUnit = ItemUnit(
      "18",
      "22")

    val result = Await.result(ItemUnitService.apply.createOrUpdate(itemUnit), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItemUnit") {
    val result = Await.result(ItemUnitService.apply.getItemUnitById("18","22"), 2.minutes)
    assert( result.head.UnitId === "22")
  }

  override protected def afterEach(): Unit = {
    //Delete All records
    ItemUnitRepository.truncate().future()
  }
}
