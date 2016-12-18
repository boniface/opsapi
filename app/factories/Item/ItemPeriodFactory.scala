package factories.Item

import domain.Item.ItemPeriod

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemPeriodFactory {

  def createItemPeriod(values: Map[String, String]):ItemPeriod=
                      {ItemPeriod(
                        ItemId = values("ItemId"),
                        PeriodId = values("PeriodId")
  )}
}
