package Item

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class ItemDictionary (ItemId:String,
                      DictionaryId:String
                     )
object ItemDictionary {
  implicit val itemDictionaryFmt = Json.format[ItemDictionary]
}