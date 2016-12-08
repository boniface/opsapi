package services.Item

import com.websudos.phantom.dsl._
import domain.Item.ItemAddress
import io.netty.util.concurrent.Future
import services.Item.Impl.ItemAddressServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemAddressService {
  def createOrUpdate(itemAddress: ItemAddress): Future[ResultSet]

  def getItemAddressById(id: String): Future[Option[ItemAddress]]

  def deleteById(id: String): Future[ResultSet]

  def getAllItemAddresses(): Future[Seq[ItemAddress]]

}
object ItemAddressService{
  def apply: ItemAddressService = new ItemAddressServiceImpl()
}