package controllers.ContactPoint
import domain.ContactPoint
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.ContactPoint.ContactPointService
/**
  * Created by 212026992 on 12/17/2016.
  */
class ContactPointController extends Controller {


  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      println(" THE INPUT IS ", input)
      val entity = Json.fromJson[ContactPoint](input).get
      val response = for {
        results <- ContactPointService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }


  def getContactPoint(contactPointId: String) = Action.async {
    request =>
      val response = for {
        results <- ContactPointService.apply.getContactPointById(contactPointId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }
}
