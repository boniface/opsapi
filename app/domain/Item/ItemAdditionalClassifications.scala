package domain.Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class ItemAdditionalClassifications(ItemId:String,
                                         ClassificationsId:String
)

object ItemAdditionalClassifications {
  implicit val itemAdditionalClassificationsFmt = Json.format[ItemAdditionalClassifications]
}
