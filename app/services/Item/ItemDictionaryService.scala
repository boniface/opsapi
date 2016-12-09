package services.Item

import Item.ItemDictionary
import com.websudos.phantom.dsl._
import io.netty.util.concurrent.Future
import services.Item.Impl.ItemDictionaryServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait ItemDictionaryService {
  def createOrUpdate(itemDictionary: ItemDictionary): Future[ResultSet]

  def getItemDictionaryById(itemId: String,Dictionary: String): Future[Option[ItemDictionary]]

  def deleteById(itemId: String,Dictionary: String): Future[ResultSet]

  def getAllItemDictionaries(): Future[Seq[ItemDictionary]]

}
object ItemDictionaryService{
  def apply: ItemDictionaryService = new ItemDictionaryServiceImpl()
}