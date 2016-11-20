package domain

import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class Organization(name: String,
                        identifier: Identifier,
                        additionalIdentifiers: List[Identifier],
                        address: Address,
                        contactPoint: ContactPoint)

object Organization{
  implicit val organizationFmt = Json.format[Organization]
}

