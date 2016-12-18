package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.{ListColumn, PrimitiveColumn}
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Revision

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
sealed class RevisionRepository extends CassandraTable[RevisionRepository,Revision] {

  object revisionId extends StringColumn(this) with PartitionKey[String]
  object date extends StringColumn(this)
  object changes extends ListColumn[Object](this)

  override def fromRow(r: Row): Revision = {
    Revision(revisionId(r),date(r),changes(r))
  }

  object RevisionRepository extends RevisionRepository with RootConnector {
    override lazy val tableName = "revision"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session

    def save(revision: Revision): Future[ResultSet] = {
      insert
        .value(_.revisionId, revision.revisionId)
        .value(_.date, revision.date)
        .value(_.changes, revision.changes)
        .future()
    }

    def getFeatureById(revisionId: String): Future[Option[Revision]] = {
      select.where(_.revisionId eqs revisionId).one()
    }

    def findAll: Future[Seq[Revision]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }

    def getFeature(revisionId: String): Future[Seq[Revision]] = {
      select.where(_.revisionId eqs revisionId).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(revisionId: String): Future[ResultSet] = {
      delete.where(_.revisionId eqs revisionId).future()
    }

  }
}
