package domain

import play.api.libs.json.Json

import scala.util.Random

/**
  * Created by sanXion on 2016/11/21.
  */
case class ProcuringEntity (name : String,
                            identifier : Identifier,
                            additionalIdentifiers : List[Identifier],
                            address : Address,
                            contactPoint : Contactpoint,
                            kind : String)

object ProcuringEntity{
  implicit val procuringEntityFmt = Json.format[ProcuringEntity]
}


