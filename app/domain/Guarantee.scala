package domain

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Guarantee (amount:Float,
                      currency:String,
                      valueAddedTaxIncluded: Boolean)

object Guarantee {
  implicit val classificationFmt = Json.format[Guarantee]
}


