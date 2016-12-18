package factories

import domain.ContactPoint
/**
  * Created by 212026992 on 12/3/2016.
  */
class ContactPointFactory {
  def createContactPoint(values:Map[String, String]):ContactPoint={
  ContactPoint(name = values("name"),email = values("email")
    ,telephone = values("telephone")
    ,faxNumber = values("faxNumber")
    ,url = values("url"))
  }

}
