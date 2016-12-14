package repositories.unit

import conf.connection.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Unit.UnitRepository

import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/14.
  */
class Unit extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    UnitRepository.create.ifNotExists().future()
  }



  override protected def afterEach(): Unit = {
    //Delete All records
    UnitRepository.truncate().future()
  }
}
