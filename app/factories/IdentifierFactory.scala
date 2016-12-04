package factories

import domain.Identifier

/**
  * Created by 212026992 on 12/3/2016.
  */
class IdentifierFactory {
  def createLot(values: Map[String,String]
               ):Identifier={
    Identifier(
      scheme = values("scheme"),
      id = values("id"),
      legalName = values("legalName"),
      uri = values("uri"))

  }
}
