package domain.Contract

import domain.Period.Period
import domain.Value.Value
import play.api.libs.json.Json

/**
  * Created by sanXion on 2016/11/24.
  */
case class Contract (id : String,
                    awardID : String,
                    contractID : String,
                    contractNumber : String,
                    title : String,
                    description : String,
                    //value : Value,
                    value : String,
                    //items : List[Item],
                    items : String,
                    //suppliers : List[Organization],
                    suppliers : String,
                    status : String,
                    //period : Period,
                    period : String,
                    dateSigned : String,
                    date : String,
                    //documents : List[Document],
                    documents : String)

object Contract{
  implicit val contractFmt = Json.format[Contract]
}