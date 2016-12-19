package controllers.Identifier
import domain.Identifier
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Identifier.IdentifierService
/**
  * Created by 212026992 on 12/17/2016.
  */
class IdentifierController extends Controller {


  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      println(" THE INPUT IS ", input)
      val entity = Json.fromJson[Identifier](input).get
      val response = for {
        results <- IdentifierService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }


  def getIdentifier(identifierId: String) = Action.async {
    request =>
      val response = for {
        results <- IdentifierService.apply.getIdentifierById(identifierId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }
}