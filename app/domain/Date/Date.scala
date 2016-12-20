package domain.Date

import play.api.libs.json.Writes.dateWrites
import play.api.libs.json.{Json, Writes};

/**
  * Created by sanXion on 2016/11/24.
  */
case class Date (date : String)

object Date{
  //implicit val customDateWrites: Writes[java.util.Date] = dateWrites("yyyy-MM-dd")
  implicit val dateFmt = Json.format[Date]
}
