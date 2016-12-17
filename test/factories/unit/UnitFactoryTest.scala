package factories.unit

import domain.Unit.Unit
import factories.Unit.UnitFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/14.
  */
class UnitFactoryTest extends FunSuite {
  test("testCreateUnit"){
    val unit = new UnitFactory

    val values = Map("code" -> "1111",
      "name" -> "test"
    )

    val units = unit.createUnit(values)

    assert(units == Unit(code = "1111",
      name = "test"))
  }
}
