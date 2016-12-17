package services.lot

import domain.Lot.Lot
import org.scalatest.FunSuite
import services.Lot.LotService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotServiceTest  extends FunSuite{
  test("testSaveOrUpdate") {
    val lot = Lot(
      "15",
      "test",
      "test",
      "test-test-test",
      "www.test.com",
      "test")

    val result = Await.result(LotService.apply.createOrUpdate(lot), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetLot") {
    val result = Await.result(LotService.apply.getLotById("15"), 2.minutes)
    assert( result.head.description === "test")
  }
}
