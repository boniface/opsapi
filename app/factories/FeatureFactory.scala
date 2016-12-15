package factories

import domain.{Feature, FeatureValue}

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class FeatureFactory {

  def createFeature(values:Map[String, String],featureValue :List[FeatureValue]):Feature={
    Feature(featureId = values("featureId"),
      code = values("code"),
      featureOf = values("featureOf"),
      relatedItem = values("relatedItem"),
      title = values("title"),
      description = values("description"),
      enum = featureValue)
  }
}
