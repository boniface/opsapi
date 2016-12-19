package factories.item

import domain.Item.ItemUnit
import factories.Item.ItemUnitFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemUnitFactoryTest extends FunSuite {
  test("testCreateItemUnit"){
    val itemUnit = new ItemUnitFactory

    val values = Map("ItemId" -> "1",
      "UnitId" -> "1"
    )

    val itemUn = itemUnit.createItemUnit(values)

    assert(itemUn == ItemUnit(ItemId = "1",
      UnitId = "1"))
  }
}
