package repositories.lot

import conf.DataConnection
import domain.Lot.LotMinimalStep
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Lot.LotMinimalStepRepository
import services.Lot.LotMinimalStepService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotMinimalStepRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    LotMinimalStepRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
    LotMinimalStepRepository.truncate().future()
  }
}
