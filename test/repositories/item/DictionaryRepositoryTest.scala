package repositories.item

import conf.DataConnection
import domain.Item.Dictionary
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Item.DictionaryRepository
import services.Item.DictionaryService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class DictionaryRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    DictionaryRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {
    val dictionary = Dictionary(
      "2",
      "test",
      "test",
      "test")

    val result = Await.result(DictionaryService.apply.createOrUpdate(dictionary), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetDictionary") {
    val result = Await.result(DictionaryService.apply.getDictionaryById("2"), 2.minutes)
    assert( result.head.elevation === "test")
  }

  override protected def afterEach(): Unit = {
    //Delete All records
    DictionaryRepository.truncate().future()
  }
}
