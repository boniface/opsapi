package factories.Lot

import domain.Lot.LotValue

/**
  * Created by AidenP on 2016/11/30.
  */
class LotValueFactory {

  def createLotValue(values: Map[String,String]):LotValue = {
    LotValue(
            LotId = values("LotId"),
            ValueId = values("ValueId"))
  }
}
