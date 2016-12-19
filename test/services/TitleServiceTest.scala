package services
import domain.Title
import org.scalatest.FunSuite
import services.Title.TitleService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by 212026992 on 12/14/2016.
  */
class TitleServiceTest extends FunSuite{

  test("testSaveOrUpdate") {
    val jobClassification = Title( "streetAddress",
      "locality",
      "region"
    )

    val result = Await.result(TitleService.apply.createOrUpdate(jobClassification), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetAddressType") {
    val result = Await.result(TitleService.apply.getTitleById("AddressTypeID"), 2.minutes)
    assert( result.head.tenderCode === "Home")
  }
}
