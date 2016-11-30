package domain.Lot

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class LotValue (LotId:String,
                     ValueId:String
)

object LotValue{
  implicit val lotValueFmt = Json.format[LotValue]
}