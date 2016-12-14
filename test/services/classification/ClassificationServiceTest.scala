package services.classification

import domain.Classification.Classification
import org.scalatest.FunSuite
import services.Classification.ClassificationService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class ClassificationServiceTest extends FunSuite {

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

}
