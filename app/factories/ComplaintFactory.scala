package factories

import domain.{Complaint, Document, Organization}

/**
  * Created by sanXion on 2016/12/11.
  */
class ComplaintFactory {
  def createComplaint(values:Map[String, String], satisfied : Boolean, organization: Organization, document :List[Document]):Complaint={
    Complaint(id = values("id"),
      author = organization,
      title  = values("String"),
      description = values("description"),
      date = values("date"),
      dateSubmitted = values("dateSubmitted"),
      dateAnswered = values("dateAnswered"),
      dateEscalated = values("dateEscalated"),
      dateDecision = values("dateDecision"),
      dateCanceled = values("dateCanceled"),
      status = values("status"),
      ttype = values("ttype"),
      resolutionType = values("resolutionType"),
      satisfied = satisfied,
      decision = values("decision"),
      cancellationReason = values("cancellationReason"),
      relatedLot = values("relatedLot"),
      tendererAction = values("tendererAction"),
      documents = document,
      tendererActionDate = values("tendererActionDate"))
  }
}
