package services

import domain.ContactPoint

import services.ContactPoint.ContactPointService
import org.scalatest.FunSuite
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by 212026992 on 12/14/2016.
  */
class ContactPointServiceTest extends FunSuite{

  test("testSaveOrUpdate") {
    val jobClassification = ContactPoint( "name",
      "email",
      "telephone",
      "faxNumber",
      "url"
    )

    val result = Await.result(ContactPointService.apply.createOrUpdate(jobClassification), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetAddressType") {
    val result = Await.result(ContactPointService.apply.getContactPointById("ContactPointID"), 2.minutes)
    assert( result.head.name === "name")
  }
}
