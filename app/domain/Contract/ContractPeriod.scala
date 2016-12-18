package domain.Contract

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/16.
  */
case class ContractPeriod (ContractId:String,
                           PeriodId:String)

object ContractPeriod{
  implicit val contractPeriodFmt = Json.format[ContractPeriod]
}