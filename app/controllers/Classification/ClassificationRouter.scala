package controllers.Classification

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ClassificationRouter  @Inject()
(classification: ClassificationController)
  extends SimpleRouter
  {
      override def routes: Routes = {
        case POST(p"/classification/create") =>
          classification.createOrUpdate()
        case GET(p"/classification/$org") =>
          classification.getClassification(org)
     /*   case GET(p"/classification/all") =>
          classification.getAllClassification()
        case PUT(p"/classification/$org") =>
          classification.createOrUpdate()
        case DELETE(p"/classification/$org") =>
          classification.deleteClassification(org)*/
      }
  }
