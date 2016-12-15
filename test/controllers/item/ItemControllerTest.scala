package controllers.item

import Item.Item
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemControllerTest extends PlaySpec with OneAppPerTest {
  val item = Item(
    "1",
    "test",
    10)

  "Routes" should {



    "ItemController" should {

      "Create Item Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/item/create")
          .withJsonBody(Json.toJson(item)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get Item From Controller" in {
        val request = route(app, FakeRequest(GET, "/item/1")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
