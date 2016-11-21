package domain

import scala.util.Random
import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/20.
  */
case class Feature (code : String = "" + Random.alphanumeric.take(8).mkString,
                    featureOf : String,
                    relatedItem : String,
                    title : String,
                    description : String,
                    enum : List[Value])

object Feature{
  implicit val featureFmt = Json.format[Feature]
}
