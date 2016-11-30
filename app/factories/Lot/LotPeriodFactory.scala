package factories.Lot

import domain.Lot.LotPeriod

/**
  * Created by AidenP on 2016/11/30.
  */
class LotPeriodFactory {

  def createLotPeriod(values: Map[String,String]):LotPeriod = {
    LotPeriod(
      LotId = values("LotId"),
      PeriodId = values("PeriodId"))
  }
}
