package repositories.Item

/**
  * Created by AidenP on 2016/11/30.
  */
class ItemRepository {
  id:String,
  description:String,
  classification:String, // classification id
  additionalClassifications:String, //additionalClassifications id
  unit:String, //lot id
  quantity:Int,
  deliveryDate:String, //deliveryDate id
  deliveryAddress:String, //deliveryAddress id
  deliveryLocation:String, //deliveryLocation id
  relatedLot:String) //Lot id
}
