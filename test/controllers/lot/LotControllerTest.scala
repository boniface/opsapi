package controllers.lot

import domain.Lot.Lot
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotControllerTest extends PlaySpec with OneAppPerTest {
  val lot = Lot(
    "15",
    "test",
    "test",
    "test-test-test",
    "www.test.com",
    "test")

  "Routes" should {



    "LotController" should {

      "Create Lot Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/lot/create")
          .withJsonBody(Json.toJson(lot)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get Lot From Controller" in {
        val request = route(app, FakeRequest(GET, "/lot/15")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
