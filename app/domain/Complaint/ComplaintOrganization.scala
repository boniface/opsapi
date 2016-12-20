package domain.Complaint

import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/12/14.
  */
case class ComplaintOrganization (ComplaintId:String,
                                  OrganizationId:String)

object ComplaintOrganization{
  implicit val complaintOrganizationFmt = Json.format[ComplaintOrganization]
}