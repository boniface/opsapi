package domain.Lot

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class LotPeriod (LotId:String,
                      PeriodId:String
)

object LotPeriod{
  implicit val lotPeriodFmt = Json.format[LotPeriod]
}
