package domain

import java.util.Date

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Cancellation (id:String,
                         reason:String,
                         reason_en:String,
                         reason_ru:String,
                         date:Date,
                         status:String,
                         documents:List[Document],
                         cancellationOf:String,
                         relatedLot:String)

object Cancellation {
  implicit val classificationFmt = Json.format[Cancellation]
}
