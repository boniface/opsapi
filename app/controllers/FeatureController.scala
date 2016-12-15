package controllers

import domain.Feature
import play.api.mvc.{Action,Controller}
import play.api.libs.json.Json
import services.FeatureService

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */

class FeatureController extends Controller{

  def createOrUpdate() = Action.async(parse.json) {
    request =>
      val input = request.body
      val entity = Json.fromJson[Feature](input).get
      val response = for {
        results <- FeatureService.apply.createOrUpdate(entity)
      } yield results
      response.map(ans => Ok(Json.toJson(entity)))
        .recover {
          case e: Exception => InternalServerError
        }
  }

  def getFeature(featureId: String) = Action.async {
    request =>
      val response = for {
        results <- FeatureService.apply.getFeature(featureId)
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

  def getAllFeature = Action.async {
    request =>
      val response = for {
        results <- FeatureService.apply.getAllFeature()
      } yield results
      response.map(ans => Ok(Json.toJson(ans)))
        .recover { case e: Exception => InternalServerError }
  }

}
