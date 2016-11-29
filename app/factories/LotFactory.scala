package factories

import domain.{Guarantee, Lot}

/**
  * Created by AidenP on 2016/11/23.
  */
class LotFactory {

  def createLot(values: Map[String,String],
             value: Value,
             //date: Date,
             guarantee:Guarantee,
             auctionPeriod: Period
            ):Lot={
                Lot(
                  id = values("id"),
                  title = values("title"),
                  description = values("description"),
                  value = value,
                  guarantee = guarantee,
                  //date = values("date") = date,
                  minimalStep = value,
                  auctionPeriod = auctionPeriod,
                  auctionUrl = values("auctionUrl"),
                  status = values("status"))
            }
}
