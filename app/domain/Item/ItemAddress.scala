package domain.Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class ItemAddress (ItemId:String,
                        AddressId:String
)
object ItemAddress {
  implicit val itemAddressFmt = Json.format[ItemAddress]
}