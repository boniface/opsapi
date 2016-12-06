package domain.Lot

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/12/06.
  */
case class LotMinimalStep (LotId:String,
                      ValueId:String
                     )

object LotMinimalStep{
  implicit val lotMinimalStepFmt = Json.format[LotMinimalStep]
}