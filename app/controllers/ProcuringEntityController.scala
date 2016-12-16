package controllers

import domain.{ProcuringEntity}
import play.api.mvc.{Action,Controller}
import play.api.libs.json.Json
import services.{ProcuringEntityService}

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class ProcuringEntityController extends Controller{

  def createOrUpdate() = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[ProcuringEntity](input).get
      val response = for {
        results <- ProcuringEntityService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getProcuringEntity(procuringEntityId: String) = Action.async {
    request =>
      val response = for {
        results <- ProcuringEntityService.apply.getProcuringEntity(procuringEntityId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllProcuringEntity = Action.async {
    request =>
      val response = for {
        results <- ProcuringEntityService.apply.getAllProcuringEntity()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

}
