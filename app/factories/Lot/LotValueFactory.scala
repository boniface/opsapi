package factories.Lot

import domain.Lot.LotValues


/**
  * Created by AidenP on 2016/11/30.
  */
class LotValueFactory {

  def createLotValue(values: Map[String,String]):LotValues = {
    LotValues(
            LotId = values("LotId"),
            ValueId = values("ValueId"))
  }
}
