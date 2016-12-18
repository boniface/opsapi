package Factories
import domain.Address
import factories.AddressFactory
import org.scalatest.FunSuite
/**
  * Created by 212026992 on 12/14/2016.
  */
class AddressFactoryTest extends FunSuite {
  test("testCreateAddress"){
    val address = new AddressFactory

    val values = Map("streetAddress" -> "test",
      "locality" -> "1",
      "region" -> "test",
      "postalCode" -> "test",
    "countryName" -> "test"
    )

    val addre = address.createAddress(values)

    assert(addre == Address(streetAddress = "test",
      locality = "1",
      region = "test",
      postalCode = "test",
      countryName = "test"))
  }
}