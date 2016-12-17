package factories.lot

import domain.Lot.LotGuarantee
import factories.Lot.LotGuaranteeFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class LotGuaranteeFactoryTest extends FunSuite {
  test("testCreateLotGuarantee"){
    val lotGuarantee = new LotGuaranteeFactory

    val values = Map("LotId" -> "1",
      "GuaranteeId" -> "1"
    )

    val lotGuar = lotGuarantee.createLotGuarantee(values)

    assert(lotGuar == LotGuarantee(LotId = "1",
      GuaranteeId = "1"))
  }
}
