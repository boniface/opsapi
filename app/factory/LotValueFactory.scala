package factories

import domain.LotValue

/**
  * Created by Administrator on 12/11/2016.
  */
class LotValueFactory
{
  def createLotValue(values: Map[String, String], value:Value, participationUrl:url): LotValue =
  {
    LotValue(value = value, relatedLot = values("relatedLot"), date = values("date"), participationUrl = participationUrl)
  }

}
