package controllers.item

import Item.ItemDictionary
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemDictionaryControllerTest extends PlaySpec with OneAppPerTest {
  val itemDictionary = ItemDictionary(
    "4",
    "8")

  "Routes" should {



    "ItemDictionaryController" should {

      "Create ItemDictionary Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/itemDictionary/create")
          .withJsonBody(Json.toJson(itemDictionary)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get ItemDictionary From Controller" in {
        val request = route(app, FakeRequest(GET, "/itemDictionary/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
