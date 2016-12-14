package repositories.lot

import conf.connection.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Lot.LotRepository

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



  override protected def afterEach(): Unit = {
    //Delete All records
    LotRepository.truncate().future()
  }
}
