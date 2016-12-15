package domain

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class ProcuringEntity (procuringEntityId:String,
                            name:String,
                            identifier: Identifier,
                            additionalIdentifiers:List[Identifier],
                            address:Address,
                            contactPoint: ContactPoint,
                            kind:String)

object ProcuringEntity {
  implicit val procuringEntityFmt = Json.format[ProcuringEntity]
}
