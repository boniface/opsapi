package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.{Feature, FeatureValue}

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
sealed class FeatureRepository extends CassandraTable[FeatureRepository,Feature] {

  object featureId extends StringColumn(this) with PartitionKey[String]
  object code extends StringColumn(this)
  object featureOf extends StringColumn(this)
  object relatedItem extends StringColumn(this)
  object title extends StringColumn(this)
  object description extends StringColumn(this)
  object enum extends ListColumn[FeatureValue](this)

  override def fromRow(r: Row): Feature = {
    Feature(featureId(r),code(r),featureOf(r),relatedItem(r),title(r),description(r),enum(r))
  }

  object FeatureRepository extends FeatureRepository with RootConnector {
    override lazy val tableName = "feature"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session

    def save(feature: Feature): Future[ResultSet] = {
      insert
        .value(_.featureId, feature.featureId)
        .value(_.code, feature.code)
        .value(_.featureOf, feature.featureOf)
        .value(_.relatedItem, feature.relatedItem)
        .value(_.title, feature.title)
        .value(_.description, feature.description)
        .value(_.enum, feature.enum)
        .future()
    }

    def getFeatureById(featureId: String): Future[Option[Feature]] = {
      select.where(_.featureId eqs featureId).one()
    }

    def findAll: Future[Seq[Feature]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }
    def getFeature(featureId: String): Future[Seq[Feature]] = {
      select.where(_.featureId eqs featureId).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(featureId: String): Future[ResultSet] = {
      delete.where(_.featureId eqs featureId).future()
    }

  }

}
