package services.Address

import com.websudos.phantom.dsl._
import domain.Address

import services.Address.Impl.AddressServiceImpl


import scala.concurrent.Future

/**
  * Created by 212026992 on 12/3/2016.
  */
trait AddressService {
  def createOrUpdate(addressType:Address):Future[ResultSet]

  def getAddressById(addressType: String): Future[Option[Address]]

  def getAllAddress(addressType: String): Future[Seq[Address]]
}

object AddressService{
  def apply: AddressService = new AddressServiceImpl()
}