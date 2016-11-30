package domain.Unit

import play.api.libs.json.Json

/**
  * Created by Aiden on 2016/11/17.
  */
case class Unit (code:String, name:String)

object Unit {
  implicit val unitFmt = Json.format[Unit]
}