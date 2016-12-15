package controllers.Lot

import domain.Lot.LotPeriod
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Lot.LotPeriodService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class LotPeriodController extends Controller {

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[LotPeriod](input).get
      val response = for {
        results <- LotPeriodService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getLotPeriod(lotId: String, periodId: String) = Action.async {
    request =>
      val response = for {
        results <- LotPeriodService.apply.getLotPeriodById(lotId, periodId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllLotPeriod() = Action.async {
    request =>
      val response = for {
        results <- LotPeriodService.apply.getAllLotPeriods()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

 /* def deleteLotPeriod(lotId: String, periodId: String) = Action.async {
    request =>
      val response = for {
        results <- LotPeriodService.apply.deleteById(lotId, periodId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
