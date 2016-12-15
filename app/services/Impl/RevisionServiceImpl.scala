package services.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.Revision
import services.{RevisionService, Service}

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class RevisionServiceImpl extends RevisionService with Service{

  override def createOrUpdate(revision: Revision): Future[ResultSet] = {
    RevisionRepository.save(revision)
  }

  override def getRevisionById(revisionId: String): Future[Option[Revision]] = {
    RevisionRepository.getRevisionById()
  }

  override def getRevision(revisionId: String): Future[Seq[Revision]] = {
    RevisionRepository.getRevisionById()
  }

  override def getAllRevision(): Future[Seq[Revision]] = {
    RevisionRepository.findAll()
  }

  override def deleteById(revisionId: String): Future[Seq[Revision]] = {
    RevisionRepository.deleteById(revisionId)
  }
}
