package services.Contract

import com.websudos.phantom.dsl._
import domain.Contract.ContractItem

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ContractItemService {
  def createOrUpdate(contractItem: ContractItem): Future[ResultSet]

  def getContractItemById(contractId: String, item: String): Future[Option[ContractItem]]

  def deleteById(contractId: String, item: String): Future[ResultSet]

  def getAllContractItems(): Future[Seq[ContractItem]]

}
object ContractItemService{
  def apply: ContractItemService = new ContractItemServiceImpl()
}