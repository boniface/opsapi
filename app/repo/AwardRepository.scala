package repositories

import domain.{Award, Document}
import com.websudos.phantom.CassandraTable

/**
  * Created by Administrator on 12/11/2016.
  */
class AwardRepository extends CassandraTable[AwardRepository, Award]
{
  object id extends StringColumn(this) with PartitionKey[String]
  object bid_id extends StringColumn(this)
  object title extends StringColumn(this)
  object description extends StringColumn(this)
  object status extends StringColumn(this)
  object date extends StringColumn(this)
  object value extends Value(this)
  object suppliers extends List[Organization](this)
  object items extends List[Organization](this)
  object documents extends List[Document](this)
  object complaints extends List[Complaint](this)
  object complainPeriod extends Period(this)
  object lotID extends StringColumn(this)


  override def fromRow(r: Row): Award = {
    Award(id(r), bid_id(r), title(r), description(r), status(r), date(r), value(r), suppliers(r), items(r), documents(r), complaints(r), complainPeriod(r), lotID(r))
  }
}

object AwardRepository extends AwardRepository with RootConnector {
  override lazy val tableName = "award"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(award: Award): Future[ResultSet] = {
    insert
      .value(_.id, award.id)
      .value(_.bid_id, award.bid_id)
      .value(_.title, award.title)
      .value(_.description, award.description)
      .value(_.status, award.status)
      .value(_.date, award.date)
      .value(_.value, award.value)
      .value(_.suppliers, award.suppliers)
      .value(_.items, award.items)
      .value(_.documents, award.documents)
      .value(_.complaints, award.complaints)
      .value(_.complainPeriod, award.complainPeriod)
      .value(_.lotID, award.lotID)
      .future()
  }

  def getAwardById(id: String):Future[Option[Award]] = {
    select.where(_.id eqs id).one()
  }
  def getAllAwards: Future[Seq[Award]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
  def getAwards(id: String): Future[Seq[Award]] = {
    select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
  }
  def deleteById(id:String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}