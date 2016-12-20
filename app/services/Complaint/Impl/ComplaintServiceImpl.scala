package services.Complaint.Impl

import com.websudos.phantom.dsl._
import domain.Complaint
import repositories.Complaint.ComplaintRepository
import services.Complaint.ComplaintService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
class ComplaintServiceImpl extends ComplaintService with Service{
  def createOrUpdate(complaint: Complaint): Future[ResultSet] = {
    ComplaintRepository.save(complaint)
  }

  def getComplaintById(id: String): Future[Option[Complaint]] = {
    ComplaintRepository.getComplaintById(id)
  }

  def getAllComplaints(): Future[Seq[Complaint]] = {
    ComplaintRepository.getAllComplaints
  }

  def deleteById(id: String): Future[ResultSet] = {
    ComplaintRepository.deleteById(id)
  }
}