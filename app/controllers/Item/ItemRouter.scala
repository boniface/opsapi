package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ItemRouter @Inject()
(item: ItemController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/item/create") =>
      item.createOrUpdate()
    case GET(p"/item/$org") =>
      item.getItem(org)
    case GET(p"/item/all") =>
      item.getAllItem()
    case PUT(p"/item/$org") =>
      item.createOrUpdate()
    /*case DELETE(p"/item/$org") =>
      item.deleteItem(org)*/
  }
}
