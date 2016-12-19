package services.Item.Impl

import com.websudos.phantom.dsl._
import domain.Item.ItemAddress
import repositories.Item.ItemAddressRepository
import services.Item.ItemAddressService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ItemAddressServiceImpl extends ItemAddressService with Service{
  def createOrUpdate(itemAddress: ItemAddress): Future[ResultSet] = {
    ItemAddressRepository.save(itemAddress)
  }

  def getItemAddressById(itemId: String, addressId: String): Future[Option[ItemAddress]] = {
    ItemAddressRepository.getItemAddressById(itemId, addressId)
  }

  def getAllItemAddresses(): Future[Seq[ItemAddress]] = {
    ItemAddressRepository.getAllItemAddresses
  }

  def deleteById(itemId: String, addressId: String): Future[ResultSet] = {
    ItemAddressRepository.deleteById(itemId, addressId)
  }

}
