package domain.Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class Dictionary (id:String,
                         latitude:String,
                         longitude:String,
                         elevation:String)

object Dictionary {
  implicit val dictionaryFmt = Json.format[Dictionary]
}
