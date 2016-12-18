package services.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.{Feature, Guarantee}
import services.{GuaranteeService, Service}

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class GuaranteeServiceImpl extends GuaranteeService with Service{

  override def createOrUpdate(guarantee: Guarantee): Future[ResultSet] = {
    GuaranteeRepository.save(guarantee)
  }

  override def getGuaranteeById(guaranteeId: String): Future[Option[Guarantee]] = {
    GuaranteeRepository.getGuaranteeById(guaranteeId)
  }

  override def getGuarantee(guaranteeId: String): Future[Seq[Guarantee]] = {
    GuaranteeRepository.getGuaranteeById(guaranteeId)
  }

  override def getAllGuarantee(): Future[Seq[Guarantee]] = {
    GuaranteeRepository.findAll()
  }

  override def deleteById(guaranteeId:String): Future[Seq[Guarantee]] = {
    GuaranteeRepository.deleteById(guaranteeId)
  }
}
