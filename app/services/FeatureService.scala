package services

import com.websudos.phantom.dsl._
import domain.{Feature}
import services.Impl.FeatureServiceImpl

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
trait FeatureService {
  def createOrUpdate(feature:Feature):Future[ResultSet]

  def getFeatureById(featureId: String): Future[Option[Feature]]

  def getFeature(featureId: String): Future[Seq[Feature]]

  def getAllFeature(): Future[Seq[Feature]]

  def deleteById(featureId: String): Future[Seq[Feature]]

}

object FeatureService{
  def apply: FeatureService = new FeatureServiceImpl()
}
