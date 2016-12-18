package controllers.document

import domain.Document.Document
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class DocumentControllerTest extends PlaySpec with OneAppPerTest {
  val document = Document(
    "12",
    Map("test"->"test"),
    "test",
    "test",
    "test",
    "www.test.com",
    "test-test-test",
    "test-test-test",
    "test",
    "test",
    "test")

  "Routes" should {



    "DocumentController" should {

      "Create Document Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/document/create")
          .withJsonBody(Json.toJson(document)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get Document From Controller" in {
        val request = route(app, FakeRequest(GET, "/document/12")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
