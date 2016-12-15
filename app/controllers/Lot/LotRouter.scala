package controllers.Lot

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class LotRouter @Inject()
(lot: LotController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/lot/create") =>
      lot.createOrUpdate()
    case GET(p"/lot/$org") =>
      lot.getLot(org)
    case GET(p"/lot/all") =>
      lot.getAllLot()
    case PUT(p"/lot/$org") =>
      lot.createOrUpdate()
   /* case DELETE(p"/lot/$org") =>
      lot.deleteLot(org)*/
  }
}
