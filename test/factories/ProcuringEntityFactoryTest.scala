package factories

import domain.{ContactPoint, Identifier}
import org.scalatest.FunSuite

import scala.collection.mutable

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class ProcuringEntityFactoryTest extends FunSuite{

  test("testCreateProcuringEntity") {
    val address = Map("streetAdress" -> "10 Dosert street","locality" -> "Cape Town","region" ->"Woodstock",
    "postal code" ->"7925", "country name" -> "South Africa")

    val identifier = Map("scheme" ->"scheme", "id" -> "12345", "legalName" -> "test","uri" -> "www.test.co.za")
    val additionalIdentifiers[Identifier] = mutable.MutableList[Identifier]()

  }
}
