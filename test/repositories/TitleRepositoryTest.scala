package repositories
import org.scalatest.{BeforeAndAfterEach, FunSuite}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._
import conf.connection.DataConnection
import domain.Title
/**
  * Created by 212026992 on 12/14/2016.
  */
class TitleRepositoryTest extends FunSuite with BeforeAndAfterEach{


  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    TitleRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {

    val fundingSources = Title(
      "10Pienaarweg",
      "CapeTown",
      "WesternCape")

    val result = Await.result(TitleRepository.save(fundingSources), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetAddress") {
    val result = Await.result(TitleRepository.geTitle("10Pienaarweg"), 2.minutes)
    assert(result.head.tenderCode === "10Pienaarweg")
  }

  override protected def afterEach(): Unit = {
    TitleRepository.truncate().future()
  }

}