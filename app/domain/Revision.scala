package domain

import java.util.Date

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Revision (author:String,
                     date:Date,
                     changes:String,
                     email:List[DictType],
                     rev:String)

object Revision {
  implicit val classificationFmt = Json.format[Revision]
}
