package services.unit

import domain.Unit.Unit
import org.scalatest.FunSuite
import services.Unit.UnitService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/14.
  */
class UnitServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val unit =  Unit(
      "12345",
      "test")

    val result = Await.result(UnitService.apply.createOrUpdate(unit), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGet Unit") {
    val result = Await.result(UnitService.apply.getUnitById("12345"), 2.minutes)
    assert( result.head.name === "test")
  }
}
