package factories.Document

import domain.Document.Document

/**
  * Created by AidenP on 2016/11/23.
  */
class DocumentFactory {



  def createDocument(values:Map[String,String], documentType:Map[String,String]):Document= {
                Document(id = values("id"),
                documentType = documentType,
                title = values("title"),
                description = values("description"),
                format = values("format"),
                url = values("url"),
                datePublished = values("datePublished"),
                dateModified = values("dateModified"),
                language = values("language"),
                documentOf = values("documentOf"),
                relatedItem = values("relatedItem"))
  }
}
