package domain

import play.api.libs.json.Json

/**
  * Created by hashcode on 2016/11/13.
  */
case class UserRole(userId: String, roleId: String)

object UserRole {
  implicit val userroleFmt = Json.format[UserRole]
}
