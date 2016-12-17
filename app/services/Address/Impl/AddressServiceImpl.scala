package services.Address.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.Address
import repositories.AddressRepository
import services.Address.AddressService
import services.Service

import scala.concurrent.Future

/**
  * Created by 212026992 on 2016/11/20.
  */
class AddressServiceImpl extends AddressService with Service{
  override def createOrUpdate(address: Address): Future[ResultSet] = {
    AddressRepository.save(address)
  }

  override def getAddressTypeById(addressType: String): Future[Option[Address]] = {
    AddressRepository.getAddressTypeById(addressType)
  }

  override def getAddressTypes(addressType: String): Future[Seq[Address]] = {
    AddressRepository.getAddressTypes(addressType)
  }
}
