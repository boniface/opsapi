package factories.item

import Item.Item
import factories.Item.ItemFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemFactoryTest extends FunSuite {
  test("testCreateItem"){
    val item = new ItemFactory

    val values = Map("id" -> "1",
      "description" -> "test",
      "quantity" -> "test"
    )

    val quan = new Integer(10)

    val it = item.createItem(values,quan)

    assert(it == Item(id = "1",
      description = "test",
      quantity = new Integer(10)))
  }
}
