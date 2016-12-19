package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ItemClassificationRouter @Inject()
(itemClassification: ItemClassificationController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/itemClassification/create") =>
      itemClassification.createOrUpdate()
    case GET(p"/itemClassification/$org/$org1") =>
      itemClassification.getItemClassification(org,org1)
    case GET(p"/itemClassification/all") =>
      itemClassification.getAllItemClassification()
    case PUT(p"/itemClassification/$org/$org1") =>
      itemClassification.createOrUpdate()
    /*case DELETE(p"/itemClassification/$org/$org1") =>
      itemClassification.deleteItemClassification(org,org1)*/
  }
}
