package controllers.Item

import Item.ItemClassification
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemClassificationService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class ItemClassificationController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ItemClassification](input).get
      val response = for {
        results <-ItemClassificationService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItemClassification (itemId: String,classificationsId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemClassificationService.apply.getItemClassificationById(itemId,classificationsId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItemClassification () = Action.async {
    request =>
      val response = for {
        results <-ItemClassificationService.apply.getAllItemClassifications()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  /*def deleteItemClassification (itemId: String,classificationsId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemClassificationService.apply.deleteById(itemId, classificationsId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
