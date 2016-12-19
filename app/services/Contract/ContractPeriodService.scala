package services.Contract

import com.websudos.phantom.dsl._
import domain.Contract.ContractPeriod

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ContractPeriodService {
  def createOrUpdate(contractPeriod: ContractPeriod): Future[ResultSet]

  def getContractPeriodById(contractId: String, period: String): Future[Option[ContractPeriod]]

  def deleteById(contractId: String, period: String): Future[ResultSet]

  def getAllContractPeriods(): Future[Seq[ContractPeriod]]

}
object ContractPeriodService{
  def apply: ContractPeriodService = new ContractPeriodServiceImpl()
}
