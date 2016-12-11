package services.Unit

import com.websudos.phantom.dsl._
import services.Unit.Impl.UnitServiceImpl
import domain.Unit.Unit

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait UnitService {
  def createOrUpdate(unit: Unit): Future[ResultSet]

  def getUnitById(id: String): Future[Option[Unit]]

  def deleteById(id: String): Future[ResultSet]

  def getAllUnits(): Future[Seq[Unit]]

}
object UnitService{
  def apply: UnitService = new UnitServiceImpl()
}