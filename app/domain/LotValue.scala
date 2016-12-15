package domain

import play.api.libs.json.Json
import sun.awt.SunHints.Value

/**
  * Created by Administrator on 11/18/2016.
  */
case class LotValue (
                    value : Value,
                    relatedLot : String,
                    date : String = Date,
                    participationUrl : url
                    )

object LotValue {
  implicit val lotValueFmt = Json.format[LotValue]
}