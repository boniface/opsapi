package controllers.Item

import domain.Item.Dictionary
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Item.DictionaryService

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by AidenP on 2016/12/13.
  */
class DictionaryController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[Dictionary](input).get
      val response = for {
        results <-DictionaryService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getDictionary (itemId: String) = Action.async {
    request =>
      val response = for {
        results <-DictionaryService.apply.getDictionaryById(itemId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllDictionary () = Action.async {
    request =>
      val response = for {
        results <-DictionaryService.apply.getAllDictionaries()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /* def deleteDictionary (itemId: String) = Action.async {
    request =>
      val response = for {
        results <-DictionaryService.apply.deleteById(itemId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
