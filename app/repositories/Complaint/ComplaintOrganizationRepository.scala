package repositories.Complaint

import domain.Complaint.ComplaintOrganization
import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/18.
  */
class ComplaintOrganizationRepository extends CassandraTable[ComplaintOrganizationRepository, ComplaintOrganization]{

  object complaintId extends StringColumn(this) with PartitionKey[String]

  object organizationId extends  StringColumn(this) with PartitionKey[String]

  override def fromRow(r: Row):ComplaintOrganization = {
    ComplaintOrganization(
      complaintId(r),
      organizationId(r))
  }
}

object ComplaintOrganizationRepository extends ComplaintOrganizationRepository with RootConnector {
  override lazy val tableName = "complaintOrganizations"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(complaintOrganization: ComplaintOrganization): Future[ResultSet] = {
    insert
      .value(_.complaintId, complaintOrganization.ComplaintId)
      .value(_.organizationId, complaintOrganization.OrganizationId)
      .future()
  }

  def getComplaintOrganizationById(ComplaintId: String, OrganizationId: String): Future[Option[ComplaintOrganization]] = {
    select.where(_.complaintId eqs ComplaintId). and(_.organizationId eqs OrganizationId).one()
  }

  def getAllComplaintOrganizations: Future[Seq[ComplaintOrganization]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getComplaintOrganization(ComplaintId: String, OrganizationId: String): Future[Seq[ComplaintOrganization]] = {
    select.where(_.complaintId eqs ComplaintId). and(_.organizationId eqs OrganizationId).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(ComplaintId: String, OrganizationId: String): Future[ResultSet] = {
    delete.where(_.complaintId eqs ComplaintId). and(_.organizationId eqs OrganizationId).future()
  }
}
