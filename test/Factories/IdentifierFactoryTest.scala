package Factories
import domain.Identifier
import factories.IdentifierFactory
import org.scalatest.FunSuite
/**
  * Created by 212026992 on 12/14/2016.
  */
class IdentifierFactoryTest extends FunSuite {
  test("testCreateIdentifier"){
    val identifier = new IdentifierFactory

    val values = Map("scheme" -> "test",
      "id" -> "1",
      "legalName" -> "test",
      "uri" -> "test"
    )

    val iden = identifier.createIdentifier(values)

    assert(iden == Identifier(scheme = "test",
      id = "1",
      legalName = "test",
      uri = "test"))
  }
}