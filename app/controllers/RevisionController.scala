package controllers

import domain.{Revision}
import play.api.mvc.{Action, Controller}
import play.api.libs.json.Json
import services.RevisionService

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class RevisionController extends Controller{

  def createOrUpdate() = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Revision](input).get
      val response = for {
        results <- RevisionService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getRevision(revisionId: String) = Action.async {
    request =>
      val response = for {
        results <- RevisionService.apply.getRevision(revisionId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllRevision = Action.async {
    request =>
      val response = for {
        results <- RevisionService.apply.getAllRevision()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

}
