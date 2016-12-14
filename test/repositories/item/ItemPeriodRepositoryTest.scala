package repositories.item

import conf.connection.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemPeriodRepository

import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemPeriodRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ItemPeriodRepository.create.ifNotExists().future()
  }



  override protected def afterEach(): Unit = {
    //Delete All records
    ItemPeriodRepository.truncate().future()
  }
}
