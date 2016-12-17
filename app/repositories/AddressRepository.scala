package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.connection.DataConnection
import domain.Address

import scala.concurrent.Future
/**
  * Created by 212026992 on 12/3/2016.
  */
sealed class AddressRepository extends CassandraTable[AddressRepository,Address]{
  object streetAddress extends StringColumn(this) with PartitionKey[String]
  object locality extends StringColumn(this)
  object region extends StringColumn(this)
  object postalCode extends StringColumn(this)
  object countryName extends StringColumn(this)

  override def fromRow(r: Row): Address = {
    Address(streetAddress(r),locality(r)
      ,region(r)
      ,postalCode(r)
      ,countryName(r))
  }
}


object AddressRepository extends AddressRepository with RootConnector {
  override lazy val tableName = "addtype"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(addtype: Address): Future[ResultSet] = {
    insert
      .value(_.streetAddress, addtype.streetAddress)
      .value(_.locality, addtype.locality)
      .value(_.region, addtype.region)
      .value(_.postalCode, addtype.postalCode)
      .value(_.countryName, addtype.countryName)
      .future()
  }

  def getAddressById(streetAddress: String):Future[Option[Address]] = {
    select.where(_.streetAddress eqs streetAddress).one()
  }
  def getAllAddress(streetAddress:String): Future[Seq[Address]] = {
    select.where(_.streetAddress eqs streetAddress).fetchEnumerator() run Iteratee.collect()
  }
  def getAddress(streetAddress: String): Future[Seq[Address]] = {
    select.where(_.streetAddress eqs streetAddress).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(streetAddress:String): Future[ResultSet] = {
    delete.where(_.streetAddress eqs streetAddress).future()
  }
}
