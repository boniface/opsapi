package domain

import domain.Document.Document
import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/24.
  */
case class Complaint (id : String,
                      author : Organization,
                      title : String,
                      description : String,
                      date : String,
                      dateSubmitted : String,
                      dateAnswered : String,
                      dateEscalated : String,
                      dateDecision : String,
                      dateCanceled : String,
                      status : String,
                      ttype : String,
                      resolutionType : String,
                      satisfied : Boolean,
                      decision : String,
                      cancellationReason : String,
                      relatedLot : String,
                      tendererAction : String,
                      documents : List[Document],
                      tendererActionDate : String)

object Complaint{
  implicit val complaintFmt = Json.format[Complaint]
}