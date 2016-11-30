package domain

import domain.Document.Document
import domain.Item.Item.Item
import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/24.
  */
class Contract (id : String,
                awardID : String,
                contractID : String,
                contractNumber : String,
                title : String,
                description : String,
                value : Value,
                items : List[Item],
                suppliers : List[Organization],
                status : String,
                period : Period,
                dateSigned : String,
                date : String = Date,
                documents : List[Document])

object Contract{
  implicit val contractFmt = Json.format[Contract]
}