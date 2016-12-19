package domain.Document

import play.api.libs.json.Json

/**
  * Created by aidenp on 2016/11/18.
  */
case class Document(id:String,
                    documentType:Map[String, String],
                    title:String,
                    description:String,
                    format:String,
                    url:String,
                    datePublished:String,
                    dateModified:String,
                    language:String,
                    documentOf:String,
                    relatedItem: String)

object Document{
  implicit val documentFmt = Json.format[Document]
}