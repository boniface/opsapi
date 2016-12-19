package services.Contract.Impl

import com.websudos.phantom.dsl._
import domain.Contract.ContractValue
import repositories.Contract.ContractValueRepository
import services.Contract.ContractValueService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ContractValueServiceImpl extends ContractValueService with Service {
  def createOrUpdate(contractValue: ContractValue): Future[ResultSet] = {
    ContractValueRepository.save(contractValue)
  }

  def getContractValueById(ContractId: String, ValueId: String): Future[Option[ContractValue]] = {
    ContractValueRepository.getContractValueById(ContractId, ValueId)
  }

  def getAllContractValues(): Future[Seq[ContractValue]] = {
    ContractValueRepository.getContractValues
  }

  def deleteById(ContractId: String, ValueId: String): Future[ResultSet] = {
    ContractValueRepository.deleteById(ContractId, ValueId)
  }
}