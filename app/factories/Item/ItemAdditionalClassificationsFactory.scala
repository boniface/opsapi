package factories.Item

import domain.Item.ItemAdditionalClassifications

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemAdditionalClassificationsFactory {

  def createItemAdditionalClassifications(values: Map[String, String]):ItemAdditionalClassifications=
                                          {ItemAdditionalClassifications(
                                            ItemId = values("ItemId"),
                                            ClassificationsId = values("ClassificationsId")
  )}
}
