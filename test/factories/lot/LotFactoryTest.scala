package factories.lot

import domain.Lot.Lot
import factories.Lot.LotFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class LotFactoryTest extends FunSuite {
  test("testCreateLot"){
    val lot = new LotFactory

    val values = Map("id" -> "1",
      "title" -> "test",
      "description" -> "test",
      "date" -> "2016/12/13",
      "auctionUrl" -> "www.test.co.za",
      "status" -> "test"
    )

    val lo = lot.createLot(values)

    assert(lo == Lot(id = "1",
      title = "test",
      description = "test",
      date = "2016/12/13",
      auctionUrl = "www.test.co.za",
      status = "test"))
  }
}
