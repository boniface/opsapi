package repositories

import domain.LotValue

/**
  * Created by Administrator on 12/14/2016.
  */
class LotValueRepository extends CassandraTable[LotValueRepository, LotValue] {

  object value extends Value(this) with PartitionKey[Value]

  object relatedLot extends StringColumn(this)

  object date extends StringColumn(this)

  object participationUrl extends url(this)

  override def fromRow(r: Row): LotValue = LotValue(value(r), relatedLot(r), date(r), participationUrl(r))
}

object LotValueRepository extends LotValueRepository with RootConnector {
  override lazy val tableName = "lotValue"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(lotValue: LotValue): Future[ResultSet] = {
    insert
      .value(_.value, lotValue.value)
      .value(_.relatedLot, lotValue.relatedLot)
      .value(_.date, lotValue.date)
      .value(_.participationUrl, lotValue.participationUrl)
      .future()
  }

  def getLotValueById(value: Value): Future[Option[LotValue]] = {
    select.where(_.value eqs value).one()
  }

  def getAllLotValues: Future[Seq[LotValue]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getLotValue(value: Value): Future[Seq[LotValue]] = {
    select.where(_.value eqs value).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(value: Value): Future[ResultSet] = {
    delete.where(_.value eqs value).future()
  }
}

}
