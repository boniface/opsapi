package repositories.lot

import conf.DataConnection
import domain.Lot.LotPeriod
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Lot.LotPeriodRepository
import services.Lot.LotPeriodService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotPeriodRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
   LotPeriodRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
   LotPeriodRepository.truncate().future()
  }
}
