package services.lot

import domain.Lot.LotMinimalStep
import org.scalatest.FunSuite
import services.Lot.LotMinimalStepService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotMinimalStepServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val lotMinimalStep = LotMinimalStep(
      "55",
      "22")

    val result = Await.result(LotMinimalStepService.apply.createOrUpdate(lotMinimalStep), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetLotMinimalStep") {
    val result = Await.result(LotMinimalStepService.apply.getLotMinimalStepById("55","22"), 2.minutes)
    assert( result.head.ValueId === "22")
  }
}
