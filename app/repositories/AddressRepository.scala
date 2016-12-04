package repositories




import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import domain.Address
import conf.connection.DataConnection


import scala.concurrent.Future
/**
  * Created by 212026992 on 12/4/2016.
  */
class AddressRepository {

  class AddressRepository extends CassandraTable[AddressRepository, Address]{

    object streetAddress extends StringColumn(this)with PartitionKey[String]
    object locality extends StringColumn(this)
    object region extends StringColumn(this)
    object postalCode extends StringColumn(this)
    object countryName extends StringColumn(this)

    override def fromRow(r: Row): Address={
      Address(
        streetAddress(r),
        locality(r),
        region(r),
        postalCode(r),
        countryName(r))
    }
  }

  object AddressRepository extends AddressRepository with RootConnector {
    override lazy val tableName = "Address"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session


    def save(address: Address): Future[ResultSet] = {
      insert
        .value(_.streetAddress, address.streetAddress)
        .value(_.locality, address.locality)
        .value(_.region, address.region)
        .value(_.postalCode, address.postalCode)
        .value(_.countryName, address.countryName)
        .future()
    }

    def getAddressById(id: String):Future[Option[Address]] = {
      select.where(_.streetAddress eqs id).one()
    }
    def getAllAddress: Future[Seq[Address]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }
    def getAddress(id: String): Future[Seq[Address]] = {
      select.where(_.streetAddress eqs id).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(id:String): Future[ResultSet] = {
      delete.where(_.streetAddress eqs id).future()
    }
  }

}
