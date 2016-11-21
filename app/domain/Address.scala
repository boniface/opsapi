package domain

import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class Address(streetAddress: String,
                   locality: String,
                   region: String,
                   postalCode: String,
                   countryName: String )

object Address{
    implicit val addressFmt = Json.format[Address]
}
