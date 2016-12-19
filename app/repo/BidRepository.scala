package repositories

import domain.{Bid, Document, LotValue, Parameter}

/**
  * Created by Administrator on 12/14/2016.
  */
class BidRepository extends CassandraTable[BidRepository, Bid]
{
  object id extends StringColumn(this) with PartitionKey[SerialVersionUID]
  object date extends StringColumn(this)
  object status extends StringColumn(this)
  object value extends Value(this)
  object lotValues extends List[LotValueRepository](this)
  object tenderers extends List[Organization](this)
  object documents extends List[Document](this)
  object parameters extends List[Parameter](this)
  object participation extends url(this)


  override def fromRow(r: Row): Bid = {
    Bid(tenderers(r), date(r), id(r), status(r), value(r), documents(r), parameters(r), lotValues(r),  participation(r))
  }
}

object BidRepository extends BidRepository with RootConnector {
  override lazy val tableName = "bid"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(bid: Bid): Future[ResultSet] = {
    insert
      .value(_.tenderers, bid.tenderers)
      .value(_.date, bid.date)
      .value(_.id, bid.id)
      .value(_.status, bid.status)
      .value(_.value, bid.value)
      .value(_.documents, bid.documents)
      .value(_.parameters, bid.parameters)
      .value(_.lotValues, bid.lotValues)
      .value(_.participation, bid.participation)
      .future()
  }

  def getBidById(id: String):Future[Option[Bid]] = {
    select.where(_.id eqs id).one()
  }
  def getAllBids: Future[Seq[Bid]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
  def getBids(id: String): Future[Seq[Bid]] = {
    select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
  }
  def deleteById(id:String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}
