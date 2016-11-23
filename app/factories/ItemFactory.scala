package factories

import domain.{Address, Classification, Item, dictionary, Unit}

/**
  * Created by AidenP on 2016/11/23.
  */
class ItemFactory {

  def createItem(values: Map[String, String],
                 classification:Classification,
                 additionalClassifications:List[Classification],
                 deliveryDate:Period,
                 deliveryAddress:Address,
                 deliveryLocation:dictionary,
                 unit:Unit, quantity:Int): Item = { Item(
                  id = values("id"),
                  description = values("description"),
                  classification = classification,
                  additionalClassifications = additionalClassifications,
                  unit = unit,
                  quantity = quantity,
                  deliveryDate = deliveryDate,
                  deliveryAddress = deliveryAddress,
                  deliveryLocation = deliveryLocation,
                  relatedLot = values("relatedLot"))
                  }

}
