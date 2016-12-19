package Factories
import domain.ContactPoint
import factories.ContactPointFactory
import org.scalatest.FunSuite
/**
  * Created by 212026992 on 12/14/2016.
  */
class ContactPointFactoryTest extends FunSuite {
  test("testCreateContactPoint"){
    val contactPoint = new ContactPointFactory

    val values = Map("name" -> "test",
      "email" -> "1",
      "telephone" -> "test",
      "faxNumber" -> "test",
    "url" -> "test"
    )

    val cp = contactPoint.createContactPoint(values)

    assert(cp == ContactPoint(name = "test",
      email = "1",
      telephone = "test",
      faxNumber = "test",
      url = "test"))
  }
}