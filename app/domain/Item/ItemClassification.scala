package Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class ItemClassification (ItemId:String,
                               ClassificationId:String
)

object ItemClassification {
  implicit val itemClassificationFmt = Json.format[ItemClassification]
}