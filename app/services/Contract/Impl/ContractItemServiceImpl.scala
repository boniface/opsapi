package services.Contract.Impl

import com.websudos.phantom.dsl._
import domain.Contract.ContractItem
import repositories.Contract.ContractItemRepository
import services.Contract.ContractItemService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ContractItemServiceImpl extends ContractItemService with Service {
  def createOrUpdate(contractItem: ContractItem): Future[ResultSet] = {
    ContractItemRepository.save(contractItem)
  }

  def getContractItemById(ContractId: String, ItemId: String): Future[Option[ContractItem]] = {
    ContractItemRepository.getContractItemById(ContractId, ItemId)
  }

  def getAllContractItems(): Future[Seq[ContractItem]] = {
    ContractItemRepository.getAllContractItems
  }

  def deleteById(ContractId: String, ItemId: String): Future[ResultSet] = {
    ContractItemRepository.deleteById(ContractId, ItemId)
  }
}
