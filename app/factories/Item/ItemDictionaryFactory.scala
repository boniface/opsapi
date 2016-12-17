package factories.Item

import Item.ItemDictionary


/**
  * Created by AidenP on 2016/11/30.
  */
class ItemDictionaryFactory {

  def createItemDictionary(values: Map[String, String]):ItemDictionary =
                          {ItemDictionary(
                            ItemId = values("ItemId"),
                            DictionaryId = values("DictionaryId")
  )}
}
