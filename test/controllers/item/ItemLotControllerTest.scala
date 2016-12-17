package controllers.item

import domain.Item.ItemLot
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemLotControllerTest extends PlaySpec with OneAppPerTest {
  val itemLot = ItemLot(
    "4",
    "8")

  "Routes" should {



    "ItemLotController" should {

      "Create ItemLot Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/itemLot/create")
          .withJsonBody(Json.toJson(itemLot)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get ItemLot From Controller" in {
        val request = route(app, FakeRequest(GET, "/itemLot/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
