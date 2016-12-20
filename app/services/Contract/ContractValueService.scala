package services.Contract

import com.websudos.phantom.dsl._
import domain.Contract.ContractValue

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ContractValueService {
  def createOrUpdate(contractValue: ContractValue): Future[ResultSet]

  def getContractValueById(contractId: String, value: String): Future[Option[ContractValue]]

  def deleteById(contractId: String, value: String): Future[ResultSet]

  def getAllContractValues(): Future[Seq[ContractValue]]

}
object ContractValueService{
  def apply: ContractValueService = new ContractValueServiceImpl()
}