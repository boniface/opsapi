package domain.Contract

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/16.
  */
case class ContractDocument (ContractId:String,
                             DocumentId:String)

object ContractDocument{
  implicit val contractDocumentFmt = Json.format[ContractDocument]
}
