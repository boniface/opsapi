package services.Contract.Impl

import com.websudos.phantom.dsl._
import domain.Contract.ContractAward
import repositories.Contract.ContractAwardRepository
import services.Contract.ContractAwardService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ContractAwardServiceImpl extends ContractAwardService with Service {
  def createOrUpdate(contractAward: ContractAward): Future[ResultSet] = {
    ContractAwardRepository.save(contractAward)
  }

  def getContractAwardById(ContractId: String, AwardId: String): Future[Option[ContractAward]] = {
    ContractAwardRepository.getContractAwardById(ContractId, AwardId)
  }

  def getAllContractAwards(): Future[Seq[ContractAward]] = {
    ContractAwardRepository.getAllContractAwards
  }

  def deleteById(ContractId: String, AwardId: String): Future[ResultSet] = {
    ContractAwardRepository.deleteById(ContractId, AwardId)
  }
}