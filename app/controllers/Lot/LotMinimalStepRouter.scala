package controllers.Lot

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._
/**
  * Created by Aiden on 2016/12/13.
  */
class LotMinimalStepRouter @Inject()
(lotMinimalStep: LotMinimalStepController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/lotMinimalStep/create") =>
      lotMinimalStep.createOrUpdate()
    case GET(p"/lotMinimalStep/$org/$org1") =>
      lotMinimalStep.getLotMinimalStep(org,org1)
    case GET(p"/lotMinimalStep/all") =>
      lotMinimalStep.getAllLotMinimalStep()
    case PUT(p"/lotMinimalStep/$org/$org1") =>
      lotMinimalStep.createOrUpdate()
   /* case DELETE(p"/lotMinimalStep/$org/$org1") =>
      lotMinimalStep.deleteLotMinimalStep(org,org1)*/
  }
}
