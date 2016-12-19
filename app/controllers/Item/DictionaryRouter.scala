package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class DictionaryRouter @Inject()
(dictionary: DictionaryController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/dictionary/create") =>
      dictionary.createOrUpdate()
    case GET(p"/dictionary/$org") =>
      dictionary.getDictionary(org)
    case GET(p"/dictionary/all") =>
      dictionary.getAllDictionary()
    case PUT(p"/dictionary/$org") =>
      dictionary.createOrUpdate()
    /*case DELETE(p"/dictionary/$org") =>
      dictionary.deleteDictionary(org)*/
  }
}
