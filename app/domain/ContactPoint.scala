package domain

import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class ContactPoint(name: String,
                        email: String,
                        telephone: String,
                        faxNumber: String,
                        url: String )

object ContactPoint{
    implicit val contactPointFmt = Json.format[ContactPoint]
}
