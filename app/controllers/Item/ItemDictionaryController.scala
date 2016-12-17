package controllers.Item

import Item.ItemDictionary
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.ItemDictionaryService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class ItemDictionaryController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ItemDictionary](input).get
      val response = for {
        results <-ItemDictionaryService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getItemDictionary (itemId: String,dictionaryId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemDictionaryService.apply.getItemDictionaryById(itemId,dictionaryId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllItemDictionary () = Action.async {
    request =>
      val response = for {
        results <-ItemDictionaryService.apply.getAllItemDictionaries()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  /*def deleteItemDictionary (itemId: String,dictionaryId: String) = Action.async {
    request =>
      val response = for {
        results <-ItemDictionaryService.apply.deleteById(itemId, dictionaryId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
