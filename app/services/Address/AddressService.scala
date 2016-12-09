package services.Address

import com.websudos.phantom.dsl._
import domain.Address
import io.netty.util.concurrent.Future
import services.Address.Impl.AddressServiceImpl

/**
  * Created by 212026992 on 12/9/2016.
  */




  trait AddressService {

    def createOrUpdate(address: Address): Future[ResultSet]

    def getAddressById(id: String): Future[Option[Address]]

    def deleteById(id: String): Future[ResultSet]

    def getAllAddress(): Future[Seq[Address]]

  }
  object AddressService{
    def apply: AddressService = new AddressServiceImpl()

  }

