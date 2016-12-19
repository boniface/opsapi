package domain.Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class ItemPeriod (ItemId:String,
                       PeriodId:String
)

object ItemPeriod {
  implicit val itemPeriodFmt = Json.format[ItemPeriod]
}