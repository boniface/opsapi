package services.lot

import domain.Lot.LotGuarantee
import org.scalatest.FunSuite
import services.Lot.LotGuaranteeService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotGuaranteeServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val lotGuarantee = LotGuarantee(
      "16",
      "28")

    val result = Await.result(LotGuaranteeService.apply.createOrUpdate(lotGuarantee), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetLotGuarantee") {
    val result = Await.result(LotGuaranteeService.apply.getLotGuaranteeById("16","18"), 2.minutes)
    assert( result.head.GuaranteeId === "18")
  }
}
