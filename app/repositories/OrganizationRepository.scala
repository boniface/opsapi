package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._



import conf.connection.DataConnection
import domain.{Identifier, Organization}
/**
  * Created by 212026992 on 12/4/2016.
  */
import scala.concurrent.Future

  class OrganizationRepository extends CassandraTable[OrganizationRepository, Organization]{





    object name extends StringColumn(this)with PartitionKey[String]
    object identifier extends StringColumn(this)
    object additionalIdentifiers extends MapColumn[ String, String](this)
    object address extends MapColumn  [ String, String](this)
    object contactPoint extends MapColumn  [ String, String](this)



    override def fromRow(r: Row): Organization={
      Organization(
        name(r),
        identifier(r),
        additionalIdentifiers(r),
        address(r),
        contactPoint(r))
    }
  }

  object OrganizationRepository extends OrganizationRepository with RootConnector {
    override lazy val tableName = "Address"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session





    def save(organization: Organization): Future[ResultSet] = {
      insert
        .value(_.name, organization.name)
        .value(_.identifier, organization.identifier)
        .value(_.additionalIdentifiers, organization.additionalIdentifiers)
        .value(_.address, organization.address)
        .value(_.contactPoint, organization.contactPoint)
        .future()
    }

    def getOrganizationById(id: String):Future[Option[Organization]] = {
      select.where(_.name eqs id).one()
    }
    def getAllOrganization: Future[Seq[Organization]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }
    def getOrganization(id: String): Future[Seq[Organization]] = {
      select.where(_.name eqs id).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(id:String): Future[ResultSet] = {
      delete.where(_.name eqs id).future()
    }


  }


