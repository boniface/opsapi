package domain

import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Feature (featureId:String,
                    code:String,
                    featureOf:String,
                    relatedItem:String,
                    title:String,
                    description:String,
                    enum:List[FeatureValue])

case class FeatureValue (value:String,
                         title:String,
                         description:String)

object Feature {
  implicit val featureFmt = Json.format[Feature]
}
