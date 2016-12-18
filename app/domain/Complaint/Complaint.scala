package domain.Complaint

import domain.Document
import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/24.
  */
case class Complaint (id : String,
                      //author : Organization,
                      author : String,
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
                      //satisfied : String,
                      decision : String,
                      cancellationReason : String,
                      relatedLot : String,
                      tendererAction : String,
                      //documents : List[Document],
                      documents : String,
                      tendererActionDate : String)

object Complaint{
  implicit val complaintFmt = Json.format[Complaint]
}