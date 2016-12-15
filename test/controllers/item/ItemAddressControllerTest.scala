package controllers.item

import domain.Item.ItemAddress
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAddressControllerTest extends PlaySpec with OneAppPerTest {
  val itemAddress = ItemAddress(
    "4",
    "8")

  "Routes" should {



    "ItemAddressController" should {

      "Create ItemAddress Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/itemAddress/create")
          .withJsonBody(Json.toJson(itemAddress)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get ItemAddress From Controller" in {
        val request = route(app, FakeRequest(GET, "/itemAddress/1")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
