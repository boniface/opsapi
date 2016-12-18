package domain.Contract

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/16.
  */
case class ContractOrganization (ContractId:String,
                                 OrganizationId:String)

object ContractOrganization{
  implicit val contractOrganizationFmt = Json.format[ContractOrganization]
}