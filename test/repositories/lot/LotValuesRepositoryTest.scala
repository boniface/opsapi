package repositories.lot

import conf.DataConnection
import domain.Lot.LotValues
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Lot.LotValuesRepository
import services.Lot.LotValuesService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotValuesRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    LotValuesRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
    LotValuesRepository.truncate().future()
  }
}
