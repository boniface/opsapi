package domain

import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class Organization(name: String,
                        identifier: String,
                        additionalIdentifiers: Map[String, String],
                        address: String,//address id
                        contactPoint: String)//contactPoint id

object Organization{
  implicit val organizationFmt = Json.format[Organization]
}

