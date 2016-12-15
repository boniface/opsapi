package controllers.Unit

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class UnitRouter @Inject()
(unit: UnitController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/unit/create") =>
      unit.createOrUpdate()
    case GET(p"/unit/$org") =>
      unit.getUnit(org)
    case GET(p"/unit/all") =>
      unit.getAllUnit()
    case PUT(p"/unit/$org") =>
      unit.createOrUpdate()
   /* case DELETE(p"/unit/$org") =>
      unit.deleteUnit(org)*/
  }
}
