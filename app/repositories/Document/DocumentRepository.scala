package repositories.Document

/**
  * Created by AidenP on 2016/11/30.
  */
class DocumentRepository {
  id:String,
  documentType:Map[String,(Map[String, String])],
  title:String,
  description:String,
  format:String,
  url:String,
  datePublished:String,
  dateModified:String,
  language:String,
  documentOf:String,
  relatedItem: String
}
