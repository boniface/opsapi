package domain.Complaint

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/18.
  */
case class ComplaintLot (ComplaintId:String,
                         LotId:String)

object ComplaintLot{
  implicit val complaintLotFmt = Json.format[ComplaintLot]
}
