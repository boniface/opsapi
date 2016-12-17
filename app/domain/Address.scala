package domain

import play.api.libs.json.Json

/**
  * Created by hashcode on 2016/08/12.
  */
case class Address(streetAddress: String,
                       locality: String,
                       region: String,
                       postalCode: String,
                       countryName: String ) {

}

object Address{
   implicit val addressFmt = Json.format[Address]
}
