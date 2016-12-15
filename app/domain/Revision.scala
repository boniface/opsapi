package domain

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Revision (revisionId:String,
                     date:String,
                     changes:List[Object])

object Revision {
  implicit val revisionFmt = Json.format[Revision]
}
