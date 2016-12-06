package factories.Lot

import domain.Lot.Lot

/**
  * Created by AidenP on 2016/11/23.
  */
class LotFactory {

  def createLot(values: Map[String,String]
            ):Lot={
                Lot(
                  id = values("id"),
                  title = values("title"),
                  description = values("description"),
                  //value = values("value"),
                  //guarantee = values("guarantee"),
                  date = values("date"),
                  //minimalStep = values("minimalStep"),
                  //auctionPeriod = values("auctionPeriod"),
                  auctionUrl = values("auctionUrl"),
                  status = values("status"))
            }
}
