package services.Date

import com.websudos.phantom.dsl._
import domain.Date.Date

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait DateService {
  def createOrUpdate(date: Date): Future[ResultSet]

  def getItemById(id: String): Future[Option[Date]]

  def deleteById(id: String): Future[ResultSet]

  def getAllItems(): Future[Seq[Date]]

}
object DateService{
  def apply: DateService = new DateServiceImpl()
}
