package domain.Lot

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class LotValues (LotId:String,
                     ValueId:String
)

object LotValues{
  implicit val lotValueFmt = Json.format[LotValues]
}