package domain

import play.api.libs.json.{Json, Writes}
import play.api.libs.json.Writes.dateWrites
import java.util.{Calendar, Date};

/**
  * Created by sanXion on 2016/11/24.
  */
case class Date (date : Option[Date])

object Date{
  implicit val customDateWrites: Writes[java.util.Date] = dateWrites("yyyy-MM-dd")
  implicit val dateFmt = Json.format[Date]
}
