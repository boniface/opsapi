package factories.Item

import Item.ItemClassification

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemClassificationFactory {

  def createItemClassification(values: Map[String, String]):ItemClassification=
                              {ItemClassification(
                                ItemId = values("ItemId"),
                                ClassificationId = values("ClassificationId")
  )}
}
