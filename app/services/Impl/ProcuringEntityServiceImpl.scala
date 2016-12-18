package services.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.ProcuringEntity
import services.{ProcuringEntityService, Service}

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class ProcuringEntityServiceImpl extends ProcuringEntityService with Service{

  override def createOrUpdate(procuringEntity: ProcuringEntity): Future[ResultSet] = {
      ProcuringEntityRepository.save(procuringEntity)
  }

  override def getProcuringEntityById(procuringEntityId: String): Future[Option[ProcuringEntity]] = {
    ProcuringEntityRepository.getProcuringEntityById(procuringEntityId)
  }

  override def getProcuringEntity(procuringEntityId: String): Future[Seq[ProcuringEntity]] = {
    ProcuringEntityRepository.getProcuringEntityById(procuringEntityId)
  }

  override def getAllProcuringEntity(): Future[Seq[ProcuringEntity]] = {
    ProcuringEntityRepository.findAll()
  }

  override def deleteById(procuringEntityId: String): Unit = {
    ProcuringEntityRepository.deleteById(procuringEntityId)
  }
}
