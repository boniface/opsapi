package controllers
import com.google.gson.Gson
import domain.Address
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.libs.json.Json
import play.api.test.FakeRequest
import play.api.test.Helpers._
/**
  * Created by 212026992 on 12/14/2016.
  */
class AddressControllerTest extends PlaySpec with OneAppPerTest {

  val gson = new Gson()
  val job = Address(
    "10Pienaarweg",
    "CapeTown",
    "WesternCape",
    "7441",
    "SouthAfrica")


  "Routes" should {
    "JobController" should {

      "Create Job Object in Through Controller" in {
        val request = route(app, FakeRequest(POST, "/address/create")
          .withJsonBody(Json.toJson(job)))
          .get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Content is ", contentAsString(request))
      }

      "Get Address From Controller" in {
        val request = route(app, FakeRequest(GET, "/address/")
        ).get
        status(request) mustBe OK
        contentType(request) mustBe Some("application/json")
        println(" The Output", contentAsJson(request))
      }
    }
  }
}
