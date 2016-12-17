package services.lot

import domain.Lot.LotValues
import org.scalatest.FunSuite
import services.Lot.LotValuesService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotValueServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val lotValue = LotValues(
      "15",
      "8")

    val result = Await.result(LotValuesService.apply.createOrUpdate(lotValue), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGet LotValue") {
    val result = Await.result(LotValuesService.apply.getLotValuesById("15","8"), 2.minutes)
    assert( result.head.ValueId === "8")
  }
}
