package controllers.Document

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class DocumentRouter @Inject()
(document: DocumentController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/document/create") =>
      document.createOrUpdate()
    case GET(p"/document/$org") =>
      document.getDocument(org)
    case GET(p"/document/all") =>
      document.getAllDocument()
    case PUT(p"/document/$org") =>
      document.createOrUpdate()
    /*case DELETE(p"/document/$org") =>
      document.deleteDocument(org)*/
  }
}