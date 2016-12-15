package controllers

import domain.{Guarantee}
import play.api.mvc.{Action,Controller}
import play.api.libs.json.Json
import services.{GuaranteeService}

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class GuaranteeController extends Controller{

  def createOrUpdate() = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Guarantee](input).get
      val response = for {
        results <- GuaranteeService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getGuarantee(guaranteeId: String) = Action.async {
    request =>
      val response = for {
        results <- GuaranteeService.apply.getGuarantee(guaranteeId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllGuarantee = Action.async {
    request =>
      val response = for {
        results <- GuaranteeService.apply.getAllGuarantee()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

}
