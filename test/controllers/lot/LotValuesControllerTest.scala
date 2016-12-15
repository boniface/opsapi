package controllers.lot

import domain.Lot.LotValues
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotValuesControllerTest extends PlaySpec with OneAppPerTest {
  val lotValues = LotValues(
    "4",
    "8")

  "Routes" should {



    "LotValueController" should {

      "Create LotValue Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/lotValues/create")
          .withJsonBody(Json.toJson(lotValues)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get LotValue From Controller" in {
        val request = route(app, FakeRequest(GET, "/lotValues/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
