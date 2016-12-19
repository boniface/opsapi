package services.Complaint

import com.websudos.phantom.dsl._
import domain.Complaint
import services.Complaint.Impl.ComplaintServiceImpl

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ComplaintService {
  def createOrUpdate(complaint: Complaint): Future[ResultSet]

  def getComplaintById(id: String): Future[Option[Complaint]]

  def deleteById(id: String): Future[ResultSet]

  def getAllComplaints(): Future[Seq[Complaint]]

}
object ComplaintService{
  def apply: ComplaintService = new ComplaintServiceImpl()
}