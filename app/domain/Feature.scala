package domain


import play.api.libs.json.Json

/**
  * Created by Mzuvukile Lawana on 2016/11/19.
  */
case class Feature (code:String,
                    featureOf:String,
                    relatedItem:String,
                    title:String,
                    title_en:String,
                    title_ru:String,
                    description:String,
                    description_en:String,
                    description_ru:String,
                    enum:List[FeatureValue])

object Feature {
  implicit val classificationFmt = Json.format[Feature]
}
