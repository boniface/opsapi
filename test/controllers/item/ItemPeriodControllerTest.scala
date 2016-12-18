package controllers.item

import domain.Item.ItemPeriod
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemPeriodControllerTest extends PlaySpec with OneAppPerTest {
  val itemPeriod = ItemPeriod(
    "4",
    "8")

  "Routes" should {



    "ItemPeriodController" should {

      "Create ItemPeriod Object in Through Controller" in {
        val request =  route(app, FakeRequest(POST, "/itemPeriod/create")
          .withJsonBody(Json.toJson(itemPeriod)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get ItemPeriod From Controller" in {
        val request = route(app, FakeRequest(GET, "/itemPeriod/4/8")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
