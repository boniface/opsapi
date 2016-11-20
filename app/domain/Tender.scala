package domain

import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class Tender(title: Title,
                  description: String,
                  tenderID: String)

object Tender{
  implicit val tenderFmt = Json.format[Tender]
}

