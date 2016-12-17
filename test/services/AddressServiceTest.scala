package services

import domain.Address
import org.scalatest.FunSuite
import services.Address.AddressService

/**
  * Created by 212026992 on 2016/11/20.
  */

import scala.concurrent.Await
import scala.concurrent.duration._

class AddressServiceTest extends FunSuite{

  test("testSaveOrUpdate") {
    val jobClassification = Address( "streetAddress",
      "locality",
      "region",
      "postalCode",
      "countryName"
      )

    val result = Await.result(AddressService.apply.createOrUpdate(jobClassification), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetAddressType") {
    val result = Await.result(AddressService.apply.getAddressById("AddressTypeID"), 2.minutes)
    assert( result.head.streetAddress === "Home")
  }
}
