package domain.Complaint

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/16.
  */
case class ComplaintDocument (ComplaintId:String,
                              DocumentId:String)

object ComplaintDocument{
  implicit val complaintDocumentFmt = Json.format[ComplaintDocument]
}
