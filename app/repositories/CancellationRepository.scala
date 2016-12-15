package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import conf.DataConnection
import com.websudos.phantom.reactivestreams._
import domain.{Cancellation, Document}

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
sealed class CancellationRepository extends CassandraTable[CancellationRepository,Cancellation] {

  object cancellationId extends StringColumn(this) with PartitionKey[String]
  object reason extends StringColumn(this)
  object date extends StringColumn(this)
  object status extends StringColumn(this)
  object documents extends ListColumn[Document](this)
  object cancellationOf extends StringColumn(this)
  object relatedLot extends StringColumn(this)

  override def fromRow(r: Row): Cancellation = {
    Cancellation(cancellationId(r),reason(r),date(r),status(r),documents(r),cancellationOf(r),relatedLot(r))
  }

  object CancellationRepository extends CancellationRepository with RootConnector {
    override lazy val tableName = "cancellation"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session

    def save(cancellation: Cancellation): Future[ResultSet] = {
      insert
        .value(_.cancellationId, cancellation.cancellationId)
        .value(_.reason, cancellation.date)
        .value(_.date, cancellation.date)
        .value(_.status, cancellation.date)
        .value(_.documents, cancellation.date)
        .value(_.cancellationOf, cancellation.date)
        .value(_.relatedLot, cancellation.relatedLot)
        .future()
    }

    def getCancellationId(cancellationId: String): Future[Option[Cancellation]] = {
      select.where(_.cancellationId eqs cancellationId).one()
    }

    def findAll: Future[Seq[Cancellation]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }

    def getCancellationById(cancellationId: String): Future[Seq[Cancellation]] = {
      select.where(_.cancellationId eqs cancellationId).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(cancellationId: String): Future[ResultSet] = {
      delete.where(_.cancellationId eqs cancellationId).future()
    }

}

}
