package repositories.classification

import conf.DataConnection
import domain.Classification.Classification
import org.scalatest.{BeforeAndAfterEach, FunSuite}
import repositories.Classification.ClassificationRepository
import services.Classification.ClassificationService

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by AidenP on 2016/12/13.
  */
class ClassificationRepositoryTest extends FunSuite with BeforeAndAfterEach{
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

  override protected def beforeEach(): Unit = {
    //Create Table
    ClassificationRepository.create.ifNotExists().future()
  }

  test("testSaveOrUpdate") {
    val classification = Classification(
      "test",
      "1",
      "test",
      "test")

    val result = Await.result(ClassificationService.apply.createOrUpdate(classification), 2.minutes)
    assert(result.isExhausted)
  }

  test("testGetClassification") {
    val result = Await.result(ClassificationService.apply.getClassificationById("1"), 2.minutes)
    assert( result.head.scheme === "test")
  }

  override protected def afterEach(): Unit = {
    //Delete All records
    ClassificationRepository.truncate().future()
  }
}
