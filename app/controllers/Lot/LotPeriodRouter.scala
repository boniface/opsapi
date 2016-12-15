package controllers.Lot

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class LotPeriodRouter @Inject()
(lotPeriod: LotPeriodController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/lotPeriod/create") =>
      lotPeriod.createOrUpdate()
    case GET(p"/lotPeriod/$org/$org1") =>
      lotPeriod.getLotPeriod(org,org1)
    case GET(p"/lotPeriod/all") =>
      lotPeriod.getAllLotPeriod()
    case PUT(p"/lotPeriod/$org/$org1") =>
      lotPeriod.createOrUpdate()
  /*  case DELETE(p"/lotPeriod/$org/$org1") =>
      lotPeriod.deleteLotPeriod(org,org1)*/
  }
}
