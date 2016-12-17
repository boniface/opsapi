package services.Classification.Impl

import com.websudos.phantom.dsl._
import domain.Classification.Classification
import repositories.Classification.ClassificationRepository
import services.Classification.ClassificationService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class ClassificationServiceImpl extends ClassificationService with Service{
  def createOrUpdate(classification: Classification): Future[ResultSet] = {
    ClassificationRepository.save(classification)
  }

  def getClassificationById(id: String): Future[Option[Classification]] = {
    ClassificationRepository.getClassificationById(id)
  }

  def getAllClassifications(): Future[Seq[Classification]] = {
    ClassificationRepository.getAllClassifications
  }

  def deleteById(id: String): Future[ResultSet] = {
    ClassificationRepository.deleteById(id)
  }
}
