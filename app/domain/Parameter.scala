package domain

import play.api.libs.json.Json

/**
  * Created by Administrator on 11/18/2016.
  */
case class Parameter (
                     code : String,
                     value : Float
                     )

object Parameter {
  implicit val parameterFmt = Json.format[Parameter]
}