package services.lot

import domain.Lot.LotPeriod
import org.scalatest.FunSuite
import services.Lot.LotPeriodService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotPeriodServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val lotPeriod = LotPeriod(
      "13",
      "40")

    val result = Await.result(LotPeriodService.apply.createOrUpdate(lotPeriod), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetLotPeriod") {
    val result = Await.result(LotPeriodService.apply.getLotPeriodById("13","40"), 2.minutes)
    assert( result.head.PeriodId === "40")
  }
}
