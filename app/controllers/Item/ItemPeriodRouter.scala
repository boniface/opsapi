package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ItemPeriodRouter @Inject()
(itemPeriod: ItemPeriodController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/itemPeriod/create") =>
      itemPeriod.createOrUpdate()
    case GET(p"/itemPeriod/$org/$org1") =>
      itemPeriod.getItemPeriod(org,org1)
    case GET(p"/itemPeriod/all") =>
      itemPeriod.getAllItemPeriod()
    case PUT(p"/itemPeriod/$org/$org1") =>
      itemPeriod.createOrUpdate()
   /* case DELETE(p"/itemPeriod/$org/$org1") =>
      itemPeriod.deleteItemPeriod(org,org1)*/
  }
}
