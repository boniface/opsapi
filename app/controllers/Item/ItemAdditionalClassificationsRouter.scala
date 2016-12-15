package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._
/**
  * Created by Aiden on 2016/12/13.
  */
class ItemAdditionalClassificationsRouter @Inject()
(itemAdditionalClassifications: ItemAdditionalClassificationsController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/itemAdditionalClassifications/create") =>
      itemAdditionalClassifications.createOrUpdate()
    case GET(p"/itemAdditionalClassifications/$org/$org1") =>
      itemAdditionalClassifications.getItemAdditionalClassification(org,org1)
    case GET(p"/itemAdditionalClassifications/all") =>
      itemAdditionalClassifications.getAllItemAdditionalClassifications()
    case PUT(p"/itemAdditionalClassifications/$org/$org1") =>
      itemAdditionalClassifications.createOrUpdate()
    /*case DELETE(p"/itemAdditionalClassifications/$org,$org1") =>
      itemAdditionalClassifications.deleteItemAdditionalClassification(org,org1)*/
  }
}
