package controllers.Lot

import domain.Lot.Lot
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Lot.LotService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/09.
  */
class LotController extends Controller {
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[Lot](input).get
      val response = for {
        results <-LotService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getLot (lotsId: String) = Action.async {
    request =>
      val response = for {
        results <-LotService.apply.getLotById(lotsId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllLot () = Action.async {
    request =>
      val response = for {
        results <-LotService.apply.getAllLots()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /* def deleteLot (lotsId: String) = Action.async {
    request =>
      val response = for {
        results <-LotService.apply.deleteById(lotsId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
