package factories.lot

import domain.Lot.LotValues
import factories.Lot.LotValueFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class LotValueFactoryTest extends FunSuite {
  test("testCreateLotValue") {
    val lotMinimalStep = new LotValueFactory

    val values = Map("LotId" -> "1",
      "ValueId" -> "1"
    )

    val lotMin = lotMinimalStep.createLotValue(values)

    assert(lotMin == LotValues(LotId = "1",
      ValueId = "1"))
  }
}
