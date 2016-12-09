package services.Item.Impl

import com.websudos.phantom.dsl._
import domain.Item.Dictionary
import repositories.Item.DictionaryRepository
import services.Item.DictionaryService
import services.Service

import scala.concurrent.Future

/**
  * Created by AidenP on 2016/12/07.
  */
class DictionaryServiceImpl extends DictionaryService with Service{

  def createOrUpdate(dictionary: Dictionary): Future[ResultSet] = {
    DictionaryRepository.save(dictionary)
  }

  def getDictionaryById(id: String): Future[Option[Dictionary]] = {
    DictionaryRepository.getDictionaryById(id)
  }

  def getAllDictionaries(): Future[Seq[Dictionary]] = {
    DictionaryRepository.getAllDictionaries
  }

  def deleteById(id: String): Future[ResultSet] = {
    DictionaryRepository.deleteById(id)
  }
  
}
