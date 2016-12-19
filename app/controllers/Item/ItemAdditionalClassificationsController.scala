package controllers.Item

import domain.Item.ItemAdditionalClassifications
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemAdditionalClassificationsService

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAdditionalClassificationsController extends Controller{
  
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ItemAdditionalClassifications](input).get
      val response = for {
        results <-ItemAdditionalClassificationsService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItemAdditionalClassification (itemId: String,classificationsId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemAdditionalClassificationsService.apply.getItemAdditionalClassificationsById(itemId,classificationsId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItemAdditionalClassifications () = Action.async {
    request =>
      val response = for {
        results <-ItemAdditionalClassificationsService.apply.getAllItemAdditionalClassifications()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /* def deleteItemAdditionalClassification (itemId: String,classificationsId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemAdditionalClassificationsService.apply.deleteById(itemId, classificationsId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
