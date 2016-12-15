package services


import domain.Address
import org.scalatest.FunSuite
import services.Address.AddressService

import scala.concurrent.Await
import scala.concurrent.duration._
/**
  * Created by 212026992 on 12/14/2016.
  */
class AddressServiceTest extends FunSuite {


  test("testSaveOrUpdate") {
    val address = Address("ORG100", "FS100", "1", "Til", "468")
    val result = Await.result(AddressService.apply.createOrUpdate(address), 2.minutes)
    assert(result.isExhausted)
  }

  test("testAddress") {
    val result = Await.result(AddressService.apply.getAddressById("ORG100"), 2.minutes)
    assert(result.head.jobClassificationId === "FS100")
  }
}
