package domain

import play.api.libs.json.Json

/**
  * Created by aidenp on 2016/11/18.
  */
case class Item (id:String,
                  description:String,
                  classification:Classification,
                  additionalClassifications: List[Classification],
                  unit:Unit,
                  quantity:Int,
                  deliveryDate:Period,
                  deliveryAddress:Address,
                  deliveryLocation:dictionary,
                  latitude:String,
                  longitude:String,
                  elevation:String,
                  relatedLot:String)

object Item {
  implicit val itemFmt = Json.format[Item]
}