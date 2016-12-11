package services.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.Feature
import services.{FeatureService, Service}

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class FeatureServiceImpl extends FeatureService with Service{

  override def createOrUpdate(feature: Feature): Future[ResultSet] = {
    FeatureRepository.save()
  }

  override def getFeatureById(featureId: String): Future[Option[Feature]] = {
    FeatureRepository.getFeatureById(featureId)
  }

  override def getFeature(featureId: String): Future[Seq[Feature]] = {
    FeatureRepository.getFeatureById(featureId)
  }

  override def getAllFeature(): Future[Seq[Feature]] = {
    FeatureRepository.findAll()
  }

  override def deleteById(featureId: String): Future[Seq[Feature]] = {
    FeatureRepository.deleteById()
  }
}
