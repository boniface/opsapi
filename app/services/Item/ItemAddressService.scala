package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemAddress
import services.Item.Impl.ItemAddressServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemAddressService {
  def createOrUpdate(itemAddress: ItemAddress): Future[ResultSet]

  def getItemAddressById(itemId: String, addressId: String): Future[Option[ItemAddress]]

  def deleteById(itemId: String, addressId: String): Future[ResultSet]

  def getAllItemAddresses(): Future[Seq[ItemAddress]]

}
object ItemAddressService{
  def apply: ItemAddressService = new ItemAddressServiceImpl()
}