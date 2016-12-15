package domain

import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class Title(tenderCode: String,
                 periodicityOfTheTender: String,
                 itemBeingProcured: String )

object Title{
  implicit val titleFmt = Json.format[Title]
}