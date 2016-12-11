package controllers

import play.api.http.MediaType.parse
import play.mvc.{Action, Controller}
import play.api.libs.json.Json
import services.CancellationService

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class CancellationController extends Controller{

//  def createOrUpdate = Action.async(parse.json) {
//    request =>
//      val input = request.body
//      val entity = Json.fromJson[Cancellation](input).get
//      val response = for {
//        results <- CancellationService.apply.save(entity)
//      } yield results
//      response.map(ans => Ok(Json.toJson(entity)))
//        .recover {
//          case e: Exception => InternalServerError
//        }
//  }
//
//  def getComment(subjectId: String) = Action.async {
//    request =>
//      val response = for {
//        results <- CommentService.apply.getCommentBySubjectId(subjectId)
//      } yield results
//      response.map(ans => Ok(Json.toJson(ans)))
//        .recover { case e: Exception => InternalServerError }
//  }
//
//  def getAllComment = Action.async {
//    request =>
//      val response = for {
//        results <- CommentService.apply.getAllComment
//      } yield results
//      response.map(ans => Ok(Json.toJson(ans)))
//        .recover { case e: Exception => InternalServerError }
//  }
}
