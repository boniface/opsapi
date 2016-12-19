package services.Contract.Impl

import com.websudos.phantom.dsl._
import domain.Contract
import repositories.Contract.ContractRepository
import services.Contract.ContractService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ContractServiceImpl extends ContractService with Service{
  def createOrUpdate(contract: Contract): Future[ResultSet] = {
    ContractRepository.save(contract)
  }

  def getContractById(id: String): Future[Option[Contract]] = {
    ContractRepository.getContractById(id)
  }

  def getAllContracts(): Future[Seq[Contract]] = {
    ContractRepository.getAllContracts
  }

  def deleteById(id: String): Future[ResultSet] = {
    ContractRepository.deleteById(id)
  }
}