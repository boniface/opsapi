package Item

import play.api.libs.json.Json

/**
  * Created by aidenp on 2016/11/18.
  */
case class Item (id:String,
                  description:String,
                 // classification:String, // classification id
                 // additionalClassifications:String, //additionalClassifications id
                 // unit:String, //lot id
                  quantity:Int)
                  //deliveryDate:String, //deliveryDate id
                 // deliveryAddress:String, //deliveryAddress id
                  //deliveryLocation:String, //deliveryLocation id
                 // relatedLot:String) //Lot id

object Item {
  implicit val itemFmt = Json.format[Item]
}