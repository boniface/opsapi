package repositories.lot

import conf.DataConnection
import domain.Lot.LotGuarantee
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Lot.LotGuaranteeRepository
import services.Lot.LotGuaranteeService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotGuaranteeRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    LotGuaranteeRepository.create.ifNotExists().future()
  }

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

  override protected def afterEach(): Unit = {
    //Delete All records
    LotGuaranteeRepository.truncate().future()
  }
}
