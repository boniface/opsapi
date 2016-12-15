package services.impl

import domain.Bid
import repositories.BidRepository
import services.{BidServices, Service}

/**
  * Created by Administrator on 12/14/2016.
  */
class BidServiceImpl extends BidServices with Service
{
  override def createOrUpdate(bid: Bid): Future[ResultSet] =
  {
    BidRepository.save(bid)
  }
  override def getBidById(id: String): Future[Option[Bid]] =
  {
    BidRepository.getBidById(id)
  }

  override def getAllBids(): Future[Seq[Bid]] =
  {
    BidRepository.getAllBids
  }
}
