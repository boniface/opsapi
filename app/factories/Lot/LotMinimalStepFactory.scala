package factories.Lot

import domain.Lot.LotMinimalStep

/**
  * Created by AidenP on 2016/12/06.
  */
class LotMinimalStepFactory {
  def createLotValue(values: Map[String,String]):LotMinimalStep = {
    LotMinimalStep(
      LotId = values("LotId"),
      ValueId = values("ValueId"))
  }
}
