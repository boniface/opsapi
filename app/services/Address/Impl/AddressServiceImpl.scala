package services.Address.Impl
import com.websudos.phantom.dsl._
import domain.Address
import repositories.Address.AddressRepository
import services.Address.AddressService
import services.Service

import scala.concurrent.Future
/**
  * Created by 212026992 on 12/9/2016.
  */


class AddressServiceImpl extends AddressService with Service{



   def createOrUpdate(address: Address): Future[ResultSet] = {
      AddressRepository.save(address)
    }

    def getAddressById(id: String): Future[Option[Address]] = {
      AddressRepository.getAddressById(id)
    }

    def getAllAddress(): Future[Seq[Address]] = {
      AddressRepository.getAllAddress
    }

    def deleteById(id: String): Future[ResultSet] = {
      AddressRepository.deleteById(id)
    }
  }

