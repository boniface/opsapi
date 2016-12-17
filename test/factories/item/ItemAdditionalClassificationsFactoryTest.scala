package factories.item

import domain.Item.ItemAdditionalClassifications
import factories.Item.ItemAdditionalClassificationsFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAdditionalClassificationsFactoryTest extends FunSuite {
  test("testCreateItemAdditionalClassifications"){
    val itemAdditionalClassifications = new ItemAdditionalClassificationsFactory

    val values = Map("ItemId" -> "1",
      "ClassificationsId" -> "1"
    )

    val classi = itemAdditionalClassifications.createItemAdditionalClassifications(values)

    assert(classi == ItemAdditionalClassifications(ItemId = "1",
      ClassificationsId = "1"))
  }
}
