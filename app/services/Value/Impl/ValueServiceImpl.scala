package services.Value.Impl

import com.websudos.phantom.dsl._
import domain.Value.Value
import repositories.Value.ValueRepository
import services.Service
import services.Value.ValueService

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/20.
  */
class ValueServiceImpl extends ValueService with Service {
  def createOrUpdate(value: Value): Future[ResultSet] = {
    ValueRepository.save(value)
  }

  def getValueByCurrency(currency: String): Future[Seq[Value]] = {
    ValueRepository.getValueByCurrency(currency)
  }

  def getAllValues(): Future[Seq[Value]] = {
    ValueRepository.getAllValues
  }

  def deleteByCurrency(currency: String): Future[ResultSet] = {
    ValueRepository.deleteByCurrency(currency)
  }
}