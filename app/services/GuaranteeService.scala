package services

import com.websudos.phantom.dsl._
import domain.Guarantee
import services.Impl.GuaranteeServiceImpl

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
trait GuaranteeService {
  def createOrUpdate(guarantee:Guarantee):Future[ResultSet]

  def getGuaranteeById(guaranteeId: String): Future[Option[Guarantee]]

  def getGuarantee(guaranteeId: String): Future[Seq[Guarantee]]

  def getAllGuarantee(): Future[Seq[Guarantee]]

  def deleteById(guaranteeId:String): Future[Seq[Guarantee]]

}

object GuaranteeService{
  def apply: GuaranteeService = new GuaranteeServiceImpl()
}
