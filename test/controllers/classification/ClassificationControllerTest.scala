package controllers.classification

import domain.Classification.Classification
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ClassificationControllerTest extends PlaySpec with OneAppPerTest {
  val classification = Classification(
    "test",
    "1",
    "test",
    "test")

  "Routes" should {



    "ClassificationController" should {

      "Create Classification Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/classification/create")
          .withJsonBody(Json.toJson(classification)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get Classification From Controller" in {
        val request = route(app, FakeRequest(GET, "/classification/1")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
