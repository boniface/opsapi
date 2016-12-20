package services.Contract.Impl

import com.websudos.phantom.dsl._
import domain.Contract.ContractPeriod
import repositories.Contract.ContractPeriodRepository
import services.Contract.ContractPeriodService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ContractPeriodServiceImpl extends ContractPeriodService with Service{
  def createOrUpdate(contractPeriod: ContractPeriod): Future[ResultSet] = {
    ContractPeriodRepository.save(contractPeriod)
  }

  def getContractPeriodById(ContractId: String, PeriodId: String): Future[Option[ContractPeriod]] = {
    ContractPeriodRepository.getContractPeriodById(ContractId, PeriodId)
  }

  def getAllContractPeriods(): Future[Seq[ContractPeriod]] = {
    ContractPeriodRepository.getContractPeriods
  }

  def deleteById(ContractId: String, PeriodId: String): Future[ResultSet] = {
    ContractPeriodRepository.deleteById(ContractId, PeriodId)
  }
}