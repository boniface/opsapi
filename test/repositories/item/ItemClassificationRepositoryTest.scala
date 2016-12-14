package repositories.item

import conf.connection.DataConnection
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.ItemClassificationRepository

import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemClassificationRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ItemClassificationRepository.create.ifNotExists().future()
  }



  override protected def afterEach(): Unit = {
    //Delete All records
    ItemClassificationRepository.truncate().future()
  }
}
