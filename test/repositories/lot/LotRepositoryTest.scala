package repositories.lot

import conf.DataConnection
import domain.Lot.Lot
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Lot.LotRepository
import services.Lot.LotService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    LotRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
    LotRepository.truncate().future()
  }
}
