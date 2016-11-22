package domain

import play.api.libs.json.Json

/**
  * Created by hashcode on 2016/11/13.
  */
case class User(userId: String,
                firstname: String,
                lastname: String,
                middlename: String,
                password: String )

object User {
  implicit val userFmt = Json.format[User]
}
