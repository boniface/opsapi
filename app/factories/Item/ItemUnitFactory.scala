package factories.Item

import domain.Item.ItemUnit

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemUnitFactory {

  def createItemUnit(values: Map[String, String]):ItemUnit =
                    {ItemUnit(
                      ItemId = values("ItemId"),
                      UnitId = values("UnitId")
  )}
}
