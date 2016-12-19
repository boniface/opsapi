package controllers.item

import Item.ItemClassification
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemClassificationControllerTest extends PlaySpec with OneAppPerTest {
  val itemClassification = ItemClassification(
    "4",
    "8")

  "Routes" should {



    "ItemClassificationController" should {

      "Create ItemClassification Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/itemClassification/create")
          .withJsonBody(Json.toJson(itemClassification)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get ItemClassification From Controller" in {
        val request = route(app, FakeRequest(GET, "/itemClassification/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
