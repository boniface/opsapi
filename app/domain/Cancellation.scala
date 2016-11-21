package domain


import java.util.UUID

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/20.
  */
case class Cancellation (id : Option[UUID],
                         relatedLot : String,
                         cancellationOf : String,
                         date : String,
                         reason : String,
                         status : String = "pending",
                         documents : List[Document])

object Cancellation{
  implicit val cancellationFmt = Json.format[Cancellation]
}