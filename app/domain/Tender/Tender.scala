package domain.Tender

import domain._
import play.api.libs.json.Json

/**
  * Created by 212026992 on 2016/11/17.
  */
case class Tender(title: Title,
                  description: String,
                  tenderID: String,
                  procuringEntity: String,//procuringEntity id
                  value: String,//value id
                  guarantee: String,//guarantee id
                  date: String,
                  items: List[Item],
                  feature: List[Feature],
                  document: List[Document],
                  questions: List[Question],
                  complaints: List[Complaint],
                  bids: List[Bid],
                  awards :List[Award],
                  contracts : List[Contract],
                  enquiryPeriod: String,
                  tenderPeriod: String,
                  auctionPeriod: String,
                  awardPeriod : String,
                  lots: List[Lot],
                  cancellations: List[Cancellation],
                  revisions:List[Revision])

object Tender{
  implicit val tenderFmt = Json.format[Tender]
}

