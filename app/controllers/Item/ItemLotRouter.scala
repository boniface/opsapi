package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ItemLotRouter @Inject()
(itemLot: ItemLotController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/itemLot/create") =>
      itemLot.createOrUpdate()
    case GET(p"/itemLot/$org/$org1") =>
      itemLot.getItemLot(org,org1)
    case GET(p"/itemLot/all") =>
      itemLot.getAllItemLot()
    case PUT(p"/itemLot/$org/$org1") =>
      itemLot.createOrUpdate()
    /*case DELETE(p"/itemLot/$org/$org1") =>
      itemLot.deleteItemLot(org,org1)*/
  }
}
