package services.Item

import com.websudos.phantom.dsl._
import domain.Item.Dictionary
import services.Item.Impl.DictionaryServiceImpl

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
trait DictionaryService {
  def createOrUpdate(dictionary: Dictionary): Future[ResultSet]

  def getDictionaryById(id: String): Future[Option[Dictionary]]

  def deleteById(id: String): Future[ResultSet]

  def getAllDictionaries(): Future[Seq[Dictionary]]

}
object  DictionaryService{
  def apply: DictionaryService = new DictionaryServiceImpl()
}