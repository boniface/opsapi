package domain.Period

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/24.
  */
case class Period (startDate : String,
                   endDate : String)

object Period{
  implicit val periodFmt = Json.format[Period]
}
