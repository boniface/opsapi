package factories

import domain.Guarantee

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class GuaranteeFactory {

  def createGuarantee(values:Map[String, String],amount: Float):Guarantee={
    Guarantee(guaranteeId = values("guaranteeId"),
      amount = amount,
      currency = values("currency"))
  }
}
