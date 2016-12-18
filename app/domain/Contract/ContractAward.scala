package domain.Contract

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/18.
  */
case class ContractAward (ContractId:String,
                          AwardId:String)

object ContractAward{
  implicit val contractAwardFmt = Json.format[ContractAward]
}
