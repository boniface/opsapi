package factories.item

import Item.ItemDictionary
import factories.Item.ItemDictionaryFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemDictionaryFactoryTest extends FunSuite {
  test("testCreateItemDictionary"){
    val itemDictionary = new ItemDictionaryFactory

    val values = Map("ItemId" -> "1",
      "DictionaryId" -> "1"
    )

    val itemDict = itemDictionary.createItemDictionary(values)

    assert(itemDict == ItemDictionary(ItemId = "1",
      DictionaryId = "1"))
  }
}
