package domain

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Guarantee (guaranteeId:String,
                      amount:Float,
                      currency:String)

object Guarantee {
  implicit val guaranteeFmt = Json.format[Guarantee]
}


