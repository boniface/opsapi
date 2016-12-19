package services.Contract

import com.websudos.phantom.dsl._
import domain.Contract
import services.Contract.Impl.ContractServiceImpl

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ContractService {
  def createOrUpdate(contract: Contract): Future[ResultSet]

  def getContractById(id: String): Future[Option[Contract]]

  def deleteById(id: String): Future[ResultSet]

  def getAllContracts(): Future[Seq[Contract]]

}
object ContractService{
  def apply: ContractService = new ContractServiceImpl()
}
