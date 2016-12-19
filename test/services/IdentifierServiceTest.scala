package services
import domain.Identifier
import org.scalatest.FunSuite
import services.Identifier.IdentifierService

import scala.concurrent.Await
import scala.concurrent.duration._
/**
  * Created by 212026992 on 12/14/2016.
  */
class IdentifierServiceTest extends FunSuite{

  test("testSaveOrUpdate") {
    val jobClassification = Identifier( "streetAddress",
      "locality",
      "region",
      "postalCode"
    )

    val result = Await.result(IdentifierService.apply.createOrUpdate(jobClassification), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetAddressType") {
    val result = Await.result(IdentifierService.apply.getIdentifierById("AddressTypeID"), 2.minutes)
    assert( result.head.id === "Home")
  }
}
