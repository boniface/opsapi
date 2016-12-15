package controllers.item

import domain.Item.Dictionary
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class DictionaryControllerTest extends PlaySpec with OneAppPerTest {
  val dictionary = Dictionary(
    "2",
    "test",
    "test",
    "test")

  "Routes" should {



    "DictionaryController" should {

      "Create Dictionary Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/dictionary/create")
          .withJsonBody(Json.toJson(dictionary)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get Dictionary From Controller" in {
        val request = route(app, FakeRequest(GET, "/dictionary/2")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
