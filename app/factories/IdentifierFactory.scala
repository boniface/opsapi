package factories

import domain.Identifier


class IdentifierFactory {
  def createIdentifier(values:Map[String, String]):Identifier={
    Identifier(scheme = values("name"),id = values("email")
    ,legalName = values("telephone")
    ,uri = values("faxNumber")
    )
  }

}
