package domain.Contract

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/16.
  */
case class ContractValue (ContractId:String,
                          ValueId:String)

object ContractValue{
  implicit val contractValueFmt = Json.format[ContractValue]
}