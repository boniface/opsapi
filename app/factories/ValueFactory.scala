package factories

import domain.Value.Value

/**
  * Created by sanXion on 2016/12/11.
  */
class ValueFactory {
  def createValue(values:Map[String, String], amount : Float, valueAddedTaxIncluded :  Boolean):Value={
    Value(amount = amount,
          currency = values("currency"),
          valueAddedTaxIncluded = valueAddedTaxIncluded)
  }
}
