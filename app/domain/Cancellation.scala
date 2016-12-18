package domain


import domain.Document.Document
import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Cancellation (cancellationId:String,
                         reason:String,
                         date: String,
                         status:String,
                         documents:List[Document],
                         cancellationOf:String,
                         relatedLot:String)

object Cancellation {
  implicit val cancellationFmt = Json.format[Cancellation]
}
