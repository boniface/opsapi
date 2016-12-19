package domain

import domain.Document.Document
import play.api.libs.json.Json

/**
  * Created by Administrator on 11/18/2016.
  */
case class Award(
                id : String,
                bid_id : String,
                title : String,
                description : String,
                status : String = Date,
                date : String = Date,
                value : Value,
                suppliers : List[Organization],
                items : List[Organization],
                documents : List[Document],
                complaints : List[Complaint],
                complainPeriod : Period,
                lotID : String
                )

object Award{
  implicit val awardFmt = Json.format[Award]
}


