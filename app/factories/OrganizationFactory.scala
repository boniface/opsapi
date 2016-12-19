package factories

import domain.{Identifier, Organization}

/**
  * Created by 212026992 on 12/3/2016.
  */
class OrganizationFactory {

  def createOrganization(values: Map[String,String],additionalIdentifiers:Map[String,String],address:Map[String,String],contactPoint:Map[String,String]
               ):Organization={
    Organization(
      name = values("name"),
      identifier = values("identifier"),
      additionalIdentifiers = additionalIdentifiers ,
      address = address,
      contactPoint = contactPoint)

  }

}
