package factories.Lot

import domain.Lot.LotGuarantee

/**
  * Created by AidenP on 2016/11/30.
  */
class LotGuaranteeFactory {

  def createLotGuarantee(values: Map[String,String]):LotGuarantee = {
    LotGuarantee(
      LotId = values("LotId"),
      GuaranteeId = values("GuaranteeId"))
  }
}
