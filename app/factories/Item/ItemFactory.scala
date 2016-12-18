package factories.Item

import Item.Item


/**
  * Created by AidenP on 2016/11/23.
  */
class ItemFactory {

  def createItem(values: Map[String, String], quantity:Int): Item =
                { Item(
                  id = values("id"),
                  description = values("description"),
                  //classification = values("description"),
                  //additionalClassifications = values("additionalClassifications"),
                 // unit = values("description"),
                  quantity = quantity
                  /*deliveryDate = values("deliveryDate"),
                  deliveryAddress = values("deliveryAddress"),
                  deliveryLocation = values("deliveryLocation"),
                  relatedLot = values("relatedLot")*/)
                  }

}
