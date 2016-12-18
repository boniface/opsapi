package factories.Item

import domain.Item.ItemLot

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemLotFactory {

  def createItemLot(values: Map[String, String]):ItemLot=
                    {ItemLot(
                      ItemId = values("ItemId"),
                      LotId = values("LotId")
  )}
}
