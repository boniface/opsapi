package repositories

import org.scalatest.{BeforeAndAfterEach, FunSuite}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._
import conf.connection.DataConnection
import domain.ContactPoint
/**
  * Created by 212026992 on 12/14/2016.
  */
class ContactPointRepositoryTest extends FunSuite with BeforeAndAfterEach{


  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    ContactPointRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {

    val fundingSources = ContactPoint(
      "10Pienaarweg",
      "CapeTown",
      "WesternCape",
      "7441",
      "SouthAfrica")

    val result = Await.result(ContactPointRepository.save(fundingSources), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetAddress") {
    val result = Await.result(ContactPointRepository.getContactPoint("10Pienaarweg"), 2.minutes)
    assert(result.head.name === "10Pienaarweg")
  }

  override protected def afterEach(): Unit = {
    AddressRepository.truncate().future()
  }

}