package factories.item

import domain.Item.ItemLot
import factories.Item.ItemLotFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemLotFactoryTest extends FunSuite {
  test("testCreateItemLot"){
    val classification = new ItemLotFactory

    val values = Map("ItemId" -> "1",
      "LotId" -> "1"
    )

    val classi = classification.createItemLot(values)

    assert(classi == ItemLot(ItemId = "1",
      LotId = "1"))
  }
}
