package services.Complaint

import com.websudos.phantom.dsl._
import domain.Complaint.ComplaintLot

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ComplaintLotService {
  def createOrUpdate(complaintLot: ComplaintLot): Future[ResultSet]

  def getComplaintLotById(complaintId: String, lot: String): Future[Option[ComplaintLot]]

  def deleteById(complaintId: String, lot: String): Future[ResultSet]

  def getAllComplaintLots(): Future[Seq[ComplaintLot]]

}
object ComplaintLotService{
  def apply: ComplaintLotService = new ComplaintLotServiceImpl()
}