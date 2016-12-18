package controllers.Item

import domain.Item.ItemAddress
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemAddressService

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAddressController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ItemAddress](input).get
      val response = for {
        results <-ItemAddressService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItemAddress (itemId: String,addressId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemAddressService.apply.getItemAddressById(itemId,addressId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItemAddress () = Action.async {
    request =>
      val response = for {
        results <-ItemAddressService.apply.getAllItemAddresses()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  /*def deleteItemAddress (itemId: String,addressId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemAddressService.apply.deleteById(itemId, addressId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
