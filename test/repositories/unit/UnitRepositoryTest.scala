package repositories.unit

import conf.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Unit.UnitRepository
import services.Unit.UnitService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/14.
  */
class UnitRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    UnitRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {
    val unit =  domain.Unit.Unit(
      "12345",
      "test")

    val result = Await.result(UnitService.apply.createOrUpdate(unit), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGet Unit") {
    val result = Await.result(UnitService.apply.getUnitById("12345"), 2.minutes)
    assert( result.head.name === "test")
  }

  override protected def afterEach(): Unit = {
    //Delete All records
    UnitRepository.truncate().future()
  }
}
