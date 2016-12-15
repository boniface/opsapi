package controllers.Item

import domain.Item.ItemLot
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemLotService

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemLotController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ ItemLot](input).get
      val response = for {
        results <- ItemLotService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItemLot (itemId: String,lotId: String) = Action.async {
    request =>
      val response = for {
        results <- ItemLotService.apply.getItemLotById(itemId,lotId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItemLot () = Action.async {
    request =>
      val response = for {
        results <- ItemLotService.apply.getAllItemLots()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /* def deleteItemLot (itemId: String,lotId: String) = Action.async {
    request =>
      val response = for {
        results <- ItemLotService.apply.deleteById(itemId, lotId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
