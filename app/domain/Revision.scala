package domain

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/19.
  */
case class Revision(Date: String,
                    Changes : List[String])

object Revision{
  implicit val revisionFmt = Json.format[Revision]
}
