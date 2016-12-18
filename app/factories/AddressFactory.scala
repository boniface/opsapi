package factories

import domain.Address
/**
  * Created by 212026992 on 12/3/2016.
  */
class AddressFactory {
  def createAddress(values:Map[String, String]):Address={
  Address(streetAddress = values("streetAddress"),locality = values("locality")
    ,region = values("region")
    ,postalCode = values("postalCode")
    ,countryName = values("countryName"))
  }

}