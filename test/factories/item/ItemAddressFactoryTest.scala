package factories.item

import domain.Item.ItemAddress
import factories.Item.ItemAddressFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ItemAddressFactoryTest extends FunSuite {
  test("testCreateItemAddress"){
    val itemAddress = new ItemAddressFactory

    val values = Map("AddressId" -> "1",
      "ItemId" -> "1"
    )

    val itemAdd = itemAddress.createItem(values)

    assert(itemAdd == ItemAddress(AddressId = "1",
      ItemId = "1"))
  }
}
