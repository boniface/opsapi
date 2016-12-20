package services.Contract

import com.websudos.phantom.dsl._
import domain.Contract.ContractAward

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ContractAwardService {
  def createOrUpdate(contractAward: ContractAward): Future[ResultSet]

  def getContractAwardById(contractId: String, award: String): Future[Option[ContractAward]]

  def deleteById(contractId: String, award: String): Future[ResultSet]

  def getAllContractAwards(): Future[Seq[ContractAward]]

}
object ContractAwardService{
  def apply: ContractAwardService = new ContractAwardServiceImpl()
}