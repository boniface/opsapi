package factories

import domain.{Award, Document}

/**
  * Created by Administrator on 12/11/2016.
  */
class AwardFactory
{
  def createAward(values: Map[String, String], value:Value, suppliers:List[Organization], items:List[Organization], documents:List[Document], complaints:List[Complaint], complainPeriod:Period):Award=
  {
    Award(id = values("id"), bid_id = values("bid_id"), title = values("title"), description = values("description"), status = values("status"), date = values("date"), value = value, suppliers = suppliers, items = items, documents =  documents, complaints = complaints, complainPeriod = complainPeriod, lotID = values("lotId"))
  }

}
