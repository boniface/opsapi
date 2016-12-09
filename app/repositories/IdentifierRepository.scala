package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.connection.DataConnection
import domain.Identifier

import scala.concurrent.Future
/**
  * Created by 212026992 on 12/4/2016.
  */


  class IdentifierRepository extends CassandraTable[IdentifierRepository, Identifier]{



    object scheme extends StringColumn(this)
    object id extends StringColumn(this)with PartitionKey[String]
    object legalName extends StringColumn(this)
    object uri extends StringColumn(this)


    override def fromRow(r: Row): Identifier={
      Identifier(
        scheme(r),
        id(r),
        legalName(r),
        uri(r))
    }
  }

  object IdentifierRepository extends IdentifierRepository with RootConnector {
    override lazy val tableName = "Address"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session





    def save(identifier: Identifier): Future[ResultSet] = {
      insert
        .value(_.scheme, identifier.scheme)
        .value(_.id, identifier.id)
        .value(_.legalName, identifier.legalName)
        .value(_.uri, identifier.uri)
        .future()
    }

    def getContactPointById(id: String):Future[Option[Identifier]] = {
      select.where(_.id eqs id).one()
    }
    def getAllContactPoint: Future[Seq[Identifier]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }
    def getContactPoint(id: String): Future[Seq[Identifier]] = {
      select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(id:String): Future[ResultSet] = {
      delete.where(_.id eqs id).future()
    }


  }

