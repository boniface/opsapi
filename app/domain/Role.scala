package domain

import play.api.libs.json.Json

/**
  * Created by hashcode on 2016/11/13.
  */
case class Role(roleId:String,rolename:String)

object Role{
    implicit val rolesFmt = Json.format[Role]
}
