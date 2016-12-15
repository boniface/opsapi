package controllers.Item

import domain.Item.ItemPeriod
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemPeriodService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class ItemPeriodController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ItemPeriod](input).get
      val response = for {
        results <-ItemPeriodService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItemPeriod (itemId: String,periodId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemPeriodService.apply.getItemPeriodById(itemId,periodId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItemPeriod () = Action.async {
    request =>
      val response = for {
        results <-ItemPeriodService.apply.getAllItemPeriods()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /* def deleteItemPeriod (itemId: String,periodId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemPeriodService.apply.deleteById(itemId, periodId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
