package services.Unit.Impl

import com.websudos.phantom.dsl._
import repositories.Unit.UnitRepository
import services.Service
import services.Unit.UnitService
import domain.Unit.Unit

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class UnitServiceImpl extends UnitService with Service{
  def createOrUpdate(unit: Unit): Future[ResultSet] = {
    UnitRepository.save(unit)
  }

  def getUnitById(id: String): Future[Option[Unit]] = {
    UnitRepository.getUnitById(id)
  }

  def getAllUnits(): Future[Seq[Unit]] = {
    UnitRepository.getAllUnits
  }

  def deleteById(id: String): Future[ResultSet] = {
    UnitRepository.deleteById(id)
  }
}
