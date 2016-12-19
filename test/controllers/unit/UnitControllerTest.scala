package controllers.unit

import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._
import domain.Unit.Unit

/**
  * Created by Aiden on 2016/12/15.
  */
class UnitControllerTest extends PlaySpec with OneAppPerTest {
  val unit = Unit(
    "12345",
    "test")

  "Routes" should {



    "UnitController" should {

      "Create Unit Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/unit/create")
          .withJsonBody(Json.toJson(unit)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get Unit From Controller" in {
        val request = route(app, FakeRequest(GET, "/unit/12345")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
