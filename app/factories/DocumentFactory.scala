package factories

import domain.Document

/**
  * Created by AidenP on 2016/11/23.
  */
class DocumentFactory {



  def createDocument(values:Map[String,String]/*,
                     datePublished:String = Date,
                     dateModified:String = Date*/):Document= {
    Document(id = values("id"),
    documentType = values("documentType"),
    title = values("title"),
    description = values("description"),
    format = values("format"),
    url = values("url"),
    //datePublished = values("") = Date,
   // dateModified = values("") = Date,
    language = values("language"),
    documentOf = values("documentOf"),
    relatedItem = values("relatedItem"))
  }
}
