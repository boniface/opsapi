package factories

import domain.{Address, ContactPoint, Identifier, ProcuringEntity}

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class ProcuringEntityFactory {

  def createProcuringEntity(values:Map[String, String], contactPoint: ContactPoint, address: Address, identifier: Identifier, additionalIdentifiers:List[Identifier]):ProcuringEntity={
    ProcuringEntity(procuringEntityId = values("procuringEntityId"),
      name = values("name"),
      identifier = identifier,
      additionalIdentifiers = additionalIdentifiers,
      address = address,
      contactPoint = contactPoint,
      kind = values("kind"))
  }

}
