package repositories.lot

import conf.connection.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Lot.LotValuesRepository

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



  override protected def afterEach(): Unit = {
    //Delete All records
    LotValuesRepository.truncate().future()
  }
}
