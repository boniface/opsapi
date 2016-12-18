package repositories.Contract

import domain.Contract.ContractDocument
import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ContractDocumentRepository extends CassandraTable[ContractDocumentRepository, ContractDocument]{

  object contractId extends StringColumn(this) with PartitionKey[String]

  object documentId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ContractDocument = {
    ContractDocument(
      contractId(r),
      documentId(r))
  }
}

object ContractDocumentRepository extends ContractDocumentRepository with RootConnector {
  override lazy val tableName = "contractDocuments"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(contractDocument: ContractDocument): Future[ResultSet] = {
    insert
      .value(_.contractId, contractDocument.ContractId)
      .value(_.documentId, contractDocument.DocumentId)
      .future()
  }

  def getContractDocumentById(ContractId: String, DocumentId: String): Future[Option[ContractDocument]] = {
    select.where(_.contractId eqs ContractId). and(_.documentId eqs DocumentId).one()
  }

  def getContractDocuments: Future[Seq[ContractDocument]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getContractDocument(ContractId: String, DocumentId: String): Future[Seq[ContractDocument]] = {
    select.where(_.contractId eqs ContractId). and(_.documentId eqs DocumentId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ContractId: String, DocumentId: String): Future[ResultSet] = {
    delete.where(_.contractId eqs ContractId). and(_.documentId eqs DocumentId).future()
  }
}