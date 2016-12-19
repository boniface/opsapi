package controllers.lot

import domain.Lot.LotMinimalStep
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotMinimalStepControllerTest extends PlaySpec with OneAppPerTest {
  val lotMinimalStep = LotMinimalStep(
    "4",
    "8")

  "Routes" should {



    "LotMinimalStepController" should {

      "Create LotMinimalStep Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/lotMinimalStep/create")
          .withJsonBody(Json.toJson(lotMinimalStep)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get LotMinimalStep From Controller" in {
        val request = route(app, FakeRequest(GET, "/lotMinimalStep/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
