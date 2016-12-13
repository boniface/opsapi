package domain

import play.api.libs.json.Json

import scala.util.Random

/**
  * Created by sanXion on 2016/11/24.
  */
case class Period (startDate : String,
                   endDate : String)

object Period{
  implicit val periodFmt = Json.format[Period]
}
