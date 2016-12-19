package factories.item

import domain.Item.ItemPeriod
import factories.Item.ItemPeriodFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemPeriodFactoryTest extends FunSuite {
  test("testCreateItemPeriod"){
    val itemPeriod = new ItemPeriodFactory

    val values = Map("ItemId" -> "1",
      "PeriodId" -> "1"
    )

    val itemPer = itemPeriod.createItemPeriod(values)

    assert(itemPer == ItemPeriod(ItemId = "1",
      PeriodId = "1"))
  }
}
