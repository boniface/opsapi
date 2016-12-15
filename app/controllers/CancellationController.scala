package controllers

import domain.Cancellation
import play.api.mvc.{Action,Controller}
import play.api.libs.json.Json
import services.CancellationService

/**
  *
  * Created by Mzuvukile Lawana on 2016/12/01.
  */

class CancellationController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request  =>
      val input = request.body
      val entity = Json.fromJson[Cancellation](input).get
      val response = for {
        results <- CancellationService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getCancellation(cancellationId: String) = Action.async {
    request =>
      val response = for {
        results <- CancellationService.apply.getCancellationById(cancellationId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllCancellation = Action.async {
    request =>
      val response = for {
        results <- CancellationService.apply.getAllCancellation()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

}
