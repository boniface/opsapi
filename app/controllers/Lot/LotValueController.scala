package controllers.Lot

import domain.Lot.LotValues
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Lot.LotValuesService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class LotValueController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[LotValues](input).get
      val response = for {
        results <-LotValuesService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getLotValue (lotId: String,valueId: String) = Action.async {
    request =>
      val response = for {
        results <-LotValuesService.apply.getLotValuesById(lotId,valueId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllLotValue () = Action.async {
    request =>
      val response = for {
        results <-LotValuesService.apply.getAllLotValues()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

/*  def deleteLotValue (lotId: String,valueId: String) = Action.async {
    request =>
      val response = for {
        results <-LotValuesService.apply.deleteById(lotId, valueId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
