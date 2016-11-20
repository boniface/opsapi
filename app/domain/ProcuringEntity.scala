package domain

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class ProcuringEntity (kind:String)

object ProcuringEntity {
  implicit val classificationFmt = Json.format[ProcuringEntity]
}
