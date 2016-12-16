package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.{ListColumn, PrimitiveColumn}
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain._
import org.json4s.Extraction
import org.json4s.native.JsonParser
import org.json4s.{NoTypeHints, _}
import org.json4s.jackson.JsonMethods._
import org.json4s.jackson.Serialization

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
sealed class ProcuringEntityRepository extends CassandraTable[ProcuringEntityRepository,ProcuringEntity] {

  object procuringEntityId extends StringColumn(this) with PartitionKey[String]
  object name extends StringColumn(this)
  object additionalIdentifiers extends ListColumn[Identifier](this)
  object kind extends StringColumn(this)

  object identifier extends JsonColumn[Identifier](this) {
    override def fromJson(obj: String): Identifier = {
      JsonParser.parse(obj).extract[Identifier]
    }

    override def toJson(obj: Identifier): String = {
      compact(Extraction.decompose(obj))
    }
  }

  object address extends JsonColumn[Address](this) {
    override def fromJson(obj: String): Address = {
      JsonParser.parse(obj).extract[Address]
    }

    override def toJson(obj: Address): String = {
      compact(Extraction.decompose(obj))
    }
  }

  object contactPoint extends JsonColumn[ContactPoint](this) {
    override def fromJson(obj: String): ContactPoint = {
      JsonParser.parse(obj).extract[ContactPoint]
    }

    override def toJson(obj: ContactPoint): String = {
      compact(Extraction.decompose(obj))
    }
  }

  override def fromRow(r: Row): ProcuringEntity = {
    ProcuringEntity(procuringEntityId(r),name(r),identifier(r),additionalIdentifiers(r),address(r),contactPoint(r),kind(r))
  }

  object ProcuringEntityRepository extends ProcuringEntityRepository with RootConnector {
    override lazy val tableName = "procuringEntity"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session

    def save(procuringEntity: ProcuringEntity): Future[ResultSet] = {
      insert
        .value(_.procuringEntityId, procuringEntity.procuringEntityId)
        .value(_.name, procuringEntity.name)
        .value(_.identifier, procuringEntity.identifier)
        .value(_.additionalIdentifiers, procuringEntity.additionalIdentifiers)
        .value(_.address, procuringEntity.address)
        .value(_.contactPoint, procuringEntity.contactPoint)
        .value(_.kind, procuringEntity.kind)
        .future()
    }

    def getProcuringEntityId(procuringEntityId: String): Future[Option[ProcuringEntity]] = {
      select.where(_.procuringEntityId eqs procuringEntityId).one()
    }

    def findAll: Future[Seq[ProcuringEntity]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }

    def getProcuringEntity(procuringEntityId: String): Future[Seq[ProcuringEntity]] = {
      select.where(_.procuringEntityId eqs procuringEntityId).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(procuringEntityId: String): Future[ResultSet] = {
      delete.where(_.procuringEntityId eqs procuringEntityId).future()
    }

  }
}
