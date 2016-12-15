package controllers.Item

import domain.Item.ItemUnit
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemUnitService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class ItemUnitController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ItemUnit](input).get
      val response = for {
        results <- ItemUnitService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItemUnit (itemId: String,unitId: String) = Action.async {
    request =>
      val response = for {
        results <- ItemUnitService.apply.getItemUnitById(itemId,unitId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItemUnit () = Action.async {
    request =>
      val response = for {
        results <- ItemUnitService.apply.getAllItemUnits()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

/*  def deleteItemUnit (itemId: String,unitId: String) = Action.async {
    request =>
      val response = for {
        results <- ItemUnitService.apply.deleteById(itemId, unitId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
