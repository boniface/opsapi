package factories.item

import Item.ItemClassification
import factories.Item.ItemClassificationFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemClassificationFactoryTest extends FunSuite {
  test("testCreateItemClassification"){
    val itemClassification = new ItemClassificationFactory

    val values = Map("ItemId" -> "1",
      "ClassificationId" -> "1"
    )

    val itemClassi = itemClassification.createItemClassification(values)

    assert(itemClassi == ItemClassification(ItemId = "1",
      ClassificationId = "1"))
  }
}
