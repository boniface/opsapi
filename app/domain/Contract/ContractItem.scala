package domain.Contract

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/16.
  */
case class ContractItem (ContractId:String,
                         ItemId:String)

object ContractItem{
  implicit val contractItemFmt = Json.format[ContractItem]
}