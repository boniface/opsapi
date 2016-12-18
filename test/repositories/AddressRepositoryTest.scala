package repositories


import conf.connection.DataConnection
import domain.Address
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration._
/**
  * Created by 212026992 on 12/14/2016.
  */
class AddressRepositoryTest extends FunSuite with BeforeAndAfterEach{


    implicit val keyspace = DataConnection.keySpace
    implicit val session = DataConnection.session

    override protected def beforeEach(): Unit = {
      AddressRepository.create.ifNotExists().future()
    }

    test("testSaveOrUpdate") {

      val fundingSources = Address(
        "10Pienaarweg",
        "CapeTown",
        "WesternCape",
        "7441",
        "SouthAfrica")

      val result = Await.result(AddressRepository.save(fundingSources), 2.minutes)
      assert(result.isExhausted)
    }

    test("testGetAddress") {
      val result = Await.result(AddressRepository.getAddress("10Pienaarweg"), 2.minutes)
      assert(result.head.streetAddress === "10Pienaarweg")
    }

    override protected def afterEach(): Unit = {
      AddressRepository.truncate().future()
    }

}
