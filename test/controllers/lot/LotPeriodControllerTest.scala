package controllers.lot

import domain.Lot.LotPeriod
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotPeriodControllerTest extends PlaySpec with OneAppPerTest {
  val lotPeriod = LotPeriod(
    "4",
    "8")

  "Routes" should {



    "LotPeriodController" should {

      "Create LotPeriod Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/lotPeriod/create")
          .withJsonBody(Json.toJson(lotPeriod)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get LotPeriod From Controller" in {
        val request = route(app, FakeRequest(GET, "/lotPeriod/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
