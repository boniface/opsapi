package controllers.Lot

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class LotValueRouter @Inject()
(lotValue: LotValueController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/lotValue/create") =>
      lotValue.createOrUpdate()
    case GET(p"/lotValue/$org/$org1") =>
      lotValue.getLotValue(org,org1)
    case GET(p"/lotValue/all") =>
      lotValue.getAllLotValue()
    case PUT(p"/lotValue/$org/$org1") =>
      lotValue.createOrUpdate()
   /* case DELETE(p"/lotValue/$org/$org1") =>
      lotValue.deleteLotValue(org,org1)*/
  }
}
