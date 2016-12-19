package services.Date.Impl

import com.websudos.phantom.dsl._
import domain.Date.Date
import repositories.Date.DateRepository
import services.Date.DateService
import services.Service

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/20.
  */
class DateServiceImpl extends DateService with Service{
  def createOrUpdate(date: Date): Future[ResultSet] = {
    DateRepository.save(date)
  }

  def getDateById(id: String): Future[Option[Date]] = {
    DateRepository.getDate(id)
  }

  def getAllDates(): Future[Seq[Date]] = {
    DateRepository.getAllDates
  }

  def deleteById(id: String): Future[ResultSet] = {
    DateRepository.deleteByDate(id)
  }
}