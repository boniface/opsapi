package services

import com.websudos.phantom.dsl._
import domain.Revision
import services.Impl.RevisionServiceImpl

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
trait RevisionService {

  def createOrUpdate(guarantee:Revision):Future[ResultSet]

  def getRevisionById(revisionId: String): Future[Option[Revision]]

  def getRevision(revisionId: String): Future[Seq[Revision]]

  def getAllRevision(): Future[Seq[Revision]]

  def deleteById(revisionId:String): Future[Seq[Revision]]

}

object RevisionService{
  def apply: RevisionService = new RevisionServiceImpl()
}
