package controllers.Item

import javax.inject.Inject

import play.api.routing.Router._
import play.api.routing.SimpleRouter
import play.api.routing.sird._

/**
  * Created by Aiden on 2016/12/13.
  */
class ItemDictionaryRouter @Inject()
(itemDictionary: ItemDictionaryController)
  extends SimpleRouter
{
  override def routes: Routes = {
    case POST(p"/itemDictionary/create") =>
      itemDictionary.createOrUpdate()
    case GET(p"/itemDictionary/$org/$org1") =>
      itemDictionary.getItemDictionary(org,org1)
    case GET(p"/itemDictionary/all") =>
      itemDictionary.getAllItemDictionary()
    case PUT(p"/itemDictionary/$org/$org1") =>
      itemDictionary.createOrUpdate()
   /* case DELETE(p"/itemDictionary/$org/$org1") =>
      itemDictionary.deleteItemDictionary(org,org1)*/
  }
}
