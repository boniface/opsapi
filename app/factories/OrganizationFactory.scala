package factories

import domain.{Identifier, Organization}

/**
  * Created by 212026992 on 12/3/2016.
  */
class OrganizationFactory {

  def createLot(values: Map[String,String],additionalIdentifiers:Map[String,String]
               ):Organization={
    Organization(
      name = values("name"),
      identifier = values("identifier"),
      additionalIdentifiers = values("additionalIdentifiers") ,
      address = values("address"),
      contactPoint = values("contactPoint"))

  }

}
