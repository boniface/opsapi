package services.Period

import com.websudos.phantom.dsl._
import domain.Period.Period
import services.Period.Impl.PeriodServiceImpl

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait PeriodService {
  def createOrUpdate(period: Period): Future[ResultSet]

  def getPeriodByStartAndEndDates(startDate: String, endDate: String): Future[Seq[Period]]

  def deleteById(id: String): Future[ResultSet]

  def getAllPeriods(): Future[Seq[Period]]

}
object PeriodService{
  def apply: PeriodService = new PeriodServiceImpl()
}