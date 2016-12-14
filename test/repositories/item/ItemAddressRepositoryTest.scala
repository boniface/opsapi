package repositories.item

import conf.connection.DataConnection
import domain.Item.ItemAddress
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemAddressRepository
import services.Item.ItemAddressService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAddressRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ItemAddressRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {
    val itemAddress = ItemAddress(
      "8",
      "6")

    val result = Await.result(ItemAddressService.apply.createOrUpdate(itemAddress), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetItemAddress") {
    val result = Await.result(ItemAddressService.apply.getItemAddressById("8","6"), 2.minutes)
    assert( result.head.AddressId === "6")
  }

  override protected def afterEach(): Unit = {
    //Delete All records
    ItemAddressRepository.truncate().future()
  }
}
