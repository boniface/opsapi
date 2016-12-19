package services.Period.Impl

import com.websudos.phantom.dsl._
import domain.Period.Period
import repositories.Period.PeriodRepository
import services.Period.PeriodService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/20.
  */
class PeriodServiceImpl extends PeriodService with Service{
  def createOrUpdate(period: Period): Future[ResultSet] = {
    PeriodRepository.save(period)
  }

  def getPeriodByStartAndEndDates(startDate: String, endDate: String): Future[Seq[Period]] = {
    PeriodRepository.getPeriod(startDate, endDate)
  }

  def getAllPeriods(): Future[Seq[Period]] = {
    PeriodRepository.getAllPeriods
  }

  def deleteById(id: String): Future[ResultSet] = {
    PeriodRepository.deleteById(id)
  }
}