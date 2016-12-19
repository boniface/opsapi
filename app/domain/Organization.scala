package domain

import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class Organization(name: String,
                        identifier: String,
                        additionalIdentifiers:Map[String, String],
                        address:Map[String, String],
                        contactPoint:Map[String, String])

object Organization{
  implicit val organizationFmt = Json.format[Organization]
}

