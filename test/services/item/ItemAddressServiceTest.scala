package services.item

import domain.Item.ItemAddress
import org.scalatest.FunSuite
import services.Item.ItemAddressService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAddressServiceTest extends FunSuite {
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
}
