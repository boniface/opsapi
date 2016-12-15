package controllers.Document

import domain.Document.Document
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import services.Document.DocumentService

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Created by AidenP on 2016/12/09.
  */
class DocumentController extends Controller{
  def createOrUpdate = Action.async(parse.json) {
    request =>
      val input = request.body
      //println(" THE INPUT IS ", input)
      val entity = Json.fromJson[Document](input).get
      val response = for {
        results <-DocumentService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getDocument (documentId: String) = Action.async {
    request =>
      val response = for {
        results <-DocumentService.apply.getDocumentById(documentId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllDocument () = Action.async {
    request =>
      val response = for {
        results <-DocumentService.apply.getAllDocuments()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

/*  def deleteDocument (documentId: String) = Action.async {
    request =>
      val response = for {
        results <-DocumentService.apply.deleteById(documentId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }*/
}
