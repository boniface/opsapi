package controllers.Lot

import domain.Lot.LotMinimalStep
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Lot.LotMinimalStepService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class LotMinimalStepController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[LotMinimalStep](input).get
      val response = for {
        results <-LotMinimalStepService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getLotMinimalStep (lotId: String,minimalStepId: String) = Action.async {
    request =>
      val response = for {
        results <-LotMinimalStepService.apply.getLotMinimalStepById(lotId,minimalStepId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllLotMinimalStep () = Action.async {
    request =>
      val response = for {
        results <-LotMinimalStepService.apply.getAllLotMinimalSteps()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /*def deleteLotMinimalStep (lotId: String,minimalStepId: String) = Action.async {
    request =>
      val response = for {
        results <-LotMinimalStepService.apply.deleteById(lotId, minimalStepId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
