package controllers.Classification

import domain.Classification.Classification
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Classification.ClassificationService

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by AidenP on 2016/12/09.
  */
class ClassificationController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      println(" THE INPUT IS ", input)
      val entity = Json.fromJson[Classification](input).get
      val response = for {
        results <- ClassificationService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

}
