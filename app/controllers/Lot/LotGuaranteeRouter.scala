package controllers.Lot

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class LotGuaranteeRouter @Inject()
(lotGuarantee: LotGuaranteeController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/lotGuarantee/create") =>
      lotGuarantee.createOrUpdate()
    case GET(p"/lotGuarantee/$org/$org1") =>
      lotGuarantee.getLotGuarantee(org,org1)
    case GET(p"/lotGuarantee/all") =>
      lotGuarantee.getAllLotGuarantee()
    case PUT(p"/lotGuarantee/$org/$org1") =>
      lotGuarantee.createOrUpdate()
   /* case DELETE(p"/lotGuarantee/$org/$org1") =>
      lotGuarantee.deleteLotGuarantee(org,org1)*/
  }
}
