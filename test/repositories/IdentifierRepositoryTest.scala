package repositories
import org.scalatest.{BeforeAndAfterEach, FunSuite}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._
import conf.connection.DataConnection
import domain.Identifier
/**
  * Created by 212026992 on 12/14/2016.
  */
class IdentifierRepositoryTest extends FunSuite with BeforeAndAfterEach{


  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    IdentifierRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {

    val fundingSources = Identifier(
      "10Pienaarweg",
      "CapeTown",
      "WesternCape",
      "7441")

    val result = Await.result(IdentifierRepository.save(fundingSources), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetIdentifier") {
    val result = Await.result(IdentifierRepository.getIdentifiers("10Pienaarweg"), 2.minutes)
    assert(result.head.id === "10Pienaarweg")
  }

  override protected def afterEach(): Unit = {
    AddressRepository.truncate().future()
  }

}