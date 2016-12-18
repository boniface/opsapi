package factories.lot

import domain.Lot.LotPeriod
import factories.Lot.LotPeriodFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class LotPeriodFactoryTest extends FunSuite {
  test("testCreateLotPeriod") {
    val lotPeriod = new LotPeriodFactory

    val values = Map("LotId" -> "1",
      "PeriodId" -> "1"
    )

    val lotPer = lotPeriod.createLotPeriod(values)

    assert(lotPer == LotPeriod(LotId = "1",
      PeriodId = "1"))
  }
}
