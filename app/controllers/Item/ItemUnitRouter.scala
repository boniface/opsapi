package controllers.Item

import javax.inject.Inject

import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ItemUnitRouter @Inject()
(document: ItemUnitController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/document/create") =>
      document.createOrUpdate()
    case GET(p"/document/$org/$org1") =>
      document.getItemUnit(org,org1)
    case GET(p"/document/all") =>
      document.getAllItemUnit()
    case PUT(p"/document/$org/$org1") =>
      document.createOrUpdate()
   /* case DELETE(p"/document/$org/$org1") =>
      document.deleteItemUnit(org,org1)*/
  }
}
