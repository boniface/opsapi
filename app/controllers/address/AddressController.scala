package controllers.address


import domain.Address
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Address.AddressService

/**
  * Created by 212026992 on 12/14/2016.
  */
class AddressController extends Controller {


  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      println(" THE INPUT IS ", input)
      val entity = Json.fromJson[Address](input).get
      val response = for {
        results <- AddressService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }


  def getAddress(addressId: String) = Action.async {
    request =>
      val response = for {
        results <- AddressService.apply.getAddressById(addressId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }
}


