package controllers.item

import domain.Item.ItemUnit
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemUnitControllerTest extends PlaySpec with OneAppPerTest {
  val itemUnit = ItemUnit(
    "4",
    "8")

  "Routes" should {



    "ItemUnitController" should {

      "Create ItemUnit Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/itemUnit/create")
          .withJsonBody(Json.toJson(itemUnit)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get ItemUnit From Controller" in {
        val request = route(app, FakeRequest(GET, "/itemUnit/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
