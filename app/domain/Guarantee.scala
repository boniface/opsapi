package domain

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/20.
  */
case class Guarantee(amount: Float,
                     currency : String = "UAH")

object Guarantee{
  implicit val guaranteeFmt = Json.format[Guarantee]
}