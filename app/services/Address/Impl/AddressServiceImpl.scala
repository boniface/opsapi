package services.Address.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.Address
import repositories.AddressRepository
import services.Address.AddressService
import services.Service

import scala.concurrent.Future

/**
  * Created by 212026992 on 12/3/2016.
  */
class AddressServiceImpl extends AddressService with Service{
  override def createOrUpdate(address: Address): Future[ResultSet] = {
    AddressRepository.save(address)
  }

  override def getAddressById(address: String): Future[Option[Address]] = {
    AddressRepository.getAddressById(address)
  }

  override def getAllAddress(address: String): Future[Seq[Address]] = {
    AddressRepository.getAllAddress(address)
  }
}
