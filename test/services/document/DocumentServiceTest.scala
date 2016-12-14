package services.document

import domain.Document.Document
import org.scalatest.FunSuite
import services.Document.DocumentService

import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by AidenP on 2016/12/13.
  */
class DocumentServiceTest extends FunSuite {
  test("testSaveOrUpdate") {
    val document = Document(
      "test",
      Map("test"->"test"),
      "12",
      "test",
      "test",
      "www.test.com",
      "test-test-test",
      "test-test-test",
      "test",
      "test",
      "test")

    val result = Await.result(DocumentService.apply.createOrUpdate(document), 2.minutes)
    assert(result.isExhausted)
  }



  test("testGetDocument") {
    val result = Await.result(DocumentService.apply.getDocumentById("12"), 2.minutes)
    assert( result.head.description === "test")
  }
}
