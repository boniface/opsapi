package domain.Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class ItemLot (ItemId:String,
                    LotId:String
)

object ItemLot {
  implicit val itemLotFmt = Json.format[ItemLot]
}