package controllers.lot

import domain.Lot.LotGuarantee
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class LotGuaranteeControllerTest extends PlaySpec with OneAppPerTest {
  val lotGuarantee = LotGuarantee(
    "4",
    "8")

  "Routes" should {



    "LotGuaranteeController" should {

      "Create LotGuarantee Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/lotGuarantee/create")
          .withJsonBody(Json.toJson(lotGuarantee)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get LotGuarantee From Controller" in {
        val request = route(app, FakeRequest(GET, "/lotGuarantee/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
