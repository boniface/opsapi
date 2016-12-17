package factories.lot

import domain.Lot.LotMinimalStep
import factories.Lot.LotMinimalStepFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class LotMinimalStepFactoryTest extends FunSuite {
  test("testCreateLotMinimalStep") {
    val lotMinimalStep = new LotMinimalStepFactory

    val values = Map("LotId" -> "1",
      "ValueId" -> "1"
    )

    val lotMin = lotMinimalStep.createLotValue(values)

    assert(lotMin == LotMinimalStep(LotId = "1",
      ValueId = "1"))
  }
}
