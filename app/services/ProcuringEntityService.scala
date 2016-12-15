package services

import com.websudos.phantom.dsl._
import domain.ProcuringEntity
import services.Impl.ProcuringEntityServiceImpl

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
trait ProcuringEntityService {

  def createOrUpdate(guarantee:ProcuringEntity):Future[ResultSet]

  def getProcuringEntityById(procuringEntityId: String): Future[Option[ProcuringEntity]]

  def getProcuringEntity(procuringEntityId: String): Future[Seq[ProcuringEntity]]

  def getAllProcuringEntity(): Future[Seq[ProcuringEntity]]

  def deleteById(procuringEntityId: String); Future[Seq[ProcuringEntity]]

}

object ProcuringEntityService{
  def apply: ProcuringEntityService = new ProcuringEntityServiceImpl()
}
