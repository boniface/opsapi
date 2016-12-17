package factories

import domain.Address

class AddressFactory {
  def createAddressType(values:Map[String, String]):Address={
  Address(streetAddress = values("streetAddress"),locality = values("locality")
    ,region = values("region")
    ,postalCode = values("postalCode")
    ,countryName = values("countryName"))
  }

}