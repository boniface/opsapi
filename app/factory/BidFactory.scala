package factories

import domain.{Bid, Document, LotValue, Parameter}

/**
  * Created by Administrator on 12/11/2016.
  */
class BidFactory
{
  def createBid(values: Map[String, String], tenderers:List[Organization], id:SerialVersionUID, value:Value, documents:List[Document],  parameters:List[Parameter], lotValues:List[LotValue], participation:url): Bid =
  {
    Bid(tenderers = tenderers, date = values("date"), id = id, status = values("status"), value = value, documents = documents, parameters = parameters, lotValues = lotValues, participation = participation)
  }
}
