package repositories.Document

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Document.Document

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/11/30.
  */
class DocumentRepository extends CassandraTable[DocumentRepository, Document]{

  object id extends StringColumn(this) with PrimaryKey[String]
  object documentType extends MapColumn[DocumentRepository,Document, String, String] (this)
  object title extends StringColumn(this)
  object description extends StringColumn(this)
  object format extends StringColumn(this)
  object url extends StringColumn(this)
  object datePublished extends StringColumn(this)
  object dateModified extends StringColumn(this)
  object language extends StringColumn(this)
  object documentOf extends StringColumn(this)
  object relatedItem extends StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row): Document={
    Document(
      id(r),
      documentType(r),
      title(r),
      description(r),
      format(r),
      url(r),
      datePublished(r),
      dateModified(r),
      language(r),
      documentOf(r),
      relatedItem(r))
  }
}

object DocumentRepository extends DocumentRepository with RootConnector {
  override lazy val tableName = "schedule"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session


  def save(document: Document): Future[ResultSet] = {
    insert
      .value(_.id, document.id)
      .value(_.documentType, document.documentType)
      .value(_.title, document.title)
      .value(_.description, document.description)
      .value(_.format, document.format)
      .value(_.url, document.url)
      .value(_.datePublished, document.datePublished)
      .value(_.dateModified, document.dateModified)
      .value(_.language, document.language)
      .value(_.documentOf, document.documentOf)
      .value(_.relatedItem, document.relatedItem)
      .future()
  }

  def getDocumentById(id: String):Future[Option[Document]] = {
    select.where(_.id eqs id).one()
  }
  def getAllDocuments: Future[Seq[Document]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }
  def getDocument(id: String): Future[Seq[Document]] = {
    select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(id:String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}


