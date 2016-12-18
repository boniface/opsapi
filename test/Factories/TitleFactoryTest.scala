package Factories
import domain.Title
import factories.TitleFactory
import org.scalatest.FunSuite
/**
  * Created by 212026992 on 12/14/2016.
  */
class TitleFactoryTest extends FunSuite {
  test("testCreateContactPoint"){
    val title = new TitleFactory

    val values = Map("tenderCode" -> "test",
      "periodicityOfTheTender" -> "1",
      "itemBeingProcured" -> "test"
    )

    val cp = title.createTitle(values)

    assert(cp == Title(tenderCode = "test",
      periodicityOfTheTender = "1",
      itemBeingProcured = "test"))
  }
}