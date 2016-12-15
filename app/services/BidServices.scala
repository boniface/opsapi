package services

import domain.Bid

/**
  * Created by Administrator on 12/14/2016.
  */
trait BidServices
{
  def createOrUpdate(bid: Bid):Future[ResultSet]
  def getAwardById(id: String):Future[Option[Bid]]
  def getAllAwards():Future[Seq[Bid]]
}
object BidServices
{
  def apply: BidServices = new BidServiceImpl()
}