package controllers.Lot

import domain.Lot.LotGuarantee
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Lot.LotGuaranteeService

import scala.concurrent.ExecutionContext.Implicits.global
/**
  * Created by AidenP on 2016/12/13.
  */
class LotGuaranteeController extends Controller{

  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[LotGuarantee](input).get
      val response = for {
        results <-LotGuaranteeService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getLotGuarantee (lotId: String,guaranteeId: String) = Action.async {
    request =>
      val response = for {
        results <-LotGuaranteeService.apply.getLotGuaranteeById(lotId,guaranteeId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllLotGuarantee () = Action.async {
    request =>
      val response = for {
        results <-LotGuaranteeService.apply.getAllLotGuarantees()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  /*def deleteLotGuarantee (lotId: String,guaranteeId: String) = Action.async {
    request =>
      val response = for {
        results <-LotGuaranteeService.apply.deleteById(lotId, guaranteeId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
