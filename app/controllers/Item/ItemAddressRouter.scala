package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ItemAddressRouter @Inject()
(itemAddress: ItemAddressController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/itemAddress/create") =>
      itemAddress.createOrUpdate()
    case GET(p"/itemAddress/$org/$org1") =>
      itemAddress.getItemAddress(org,org1)
    case GET(p"/itemAddress/all") =>
      itemAddress.getAllItemAddress()
    case PUT(p"/itemAddress/$org") =>
      itemAddress.createOrUpdate()
    /*case DELETE(p"/itemAddress/$org/$org1") =>
      itemAddress.deleteItemAddress(org,org1)*/
  }
}
