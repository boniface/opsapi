package controllers.item

import domain.Item.ItemAdditionalClassifications
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAdditionalClassificationsControllerTest extends PlaySpec with OneAppPerTest {
  val itemAdditionalClassifications = ItemAdditionalClassifications(
    "4",
    "8")

  "Routes" should {



    "ItemAdditionalClassificationsController" should {

      "Create ItemAdditionalClassifications Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/itemAdditionalClassifications/create")
          .withJsonBody(Json.toJson(itemAdditionalClassifications)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get ItemAdditionalClassifications From Controller" in {
        val request = route(app, FakeRequest(GET, "/itemAdditionalClassifications/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
