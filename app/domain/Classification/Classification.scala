package domain.Classification

import play.api.libs.json.Json

/**
  * Created by aidenp on 2016/11/18.
  */
case class Classification (scheme:String,
                           id:String,
                           description:String,
                           uri:String)

object Classification {
  implicit val classificationFmt = Json.format[Classification]
}