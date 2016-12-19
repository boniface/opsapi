package domain.Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class ItemUnit (ItemId:String,
                     UnitId:String
)

object ItemUnit {
  implicit val itemUnitFmt = Json.format[ItemUnit]
}