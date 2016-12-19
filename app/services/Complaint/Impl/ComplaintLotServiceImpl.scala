package services.Complaint.Impl

import com.websudos.phantom.dsl._
import domain.Complaint.ComplaintLot
import repositories.Complaint.ComplaintLotRepository
import services.Complaint.ComplaintLotService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ComplaintLotServiceImpl extends ComplaintLotService with Service {
  def createOrUpdate(complaintLot: ComplaintLot): Future[ResultSet] = {
    ComplaintLotRepository.save(complaintLot)
  }

  def getComplaintLotById(ComplaintId: String, LotId: String): Future[Option[ComplaintLot]] = {
    ComplaintLotRepository.getComplaintLotById(ComplaintId, LotId)
  }

  def getAllComplaintLots(): Future[Seq[ComplaintLot]] = {
    ComplaintLotRepository.getAllComplaintLots
  }

  def deleteById(ComplaintId: String, LotId: String): Future[ResultSet] = {
    ComplaintLotRepository.deleteById(ComplaintId, LotId)
  }
}