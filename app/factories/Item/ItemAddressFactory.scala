package factories.Item

import domain.Item.ItemAddress

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemAddressFactory {

  def createItem(values: Map[String, String]):ItemAddress =
                {ItemAddress(
                  ItemId = values("ItemId"),
                  AddressId = values("AddressId")
  )}
}
