package controllers.Item

import Item.Item
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/09.
  */
class ItemController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[Item](input).get
      val response = for {
        results <-ItemService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItem (itemId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemService.apply.getItemById(itemId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItem () = Action.async {
    request =>
      val response = for {
        results <-ItemService.apply.getAllItems()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /* def deleteItem (itemId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemService.apply.deleteById(itemId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
