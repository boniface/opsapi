package services.Title.Impl
import services.Service
import com.websudos.phantom.dsl._
import domain.Title
import repositories.TitleRepository
import services.Title.TitleService

import scala.concurrent.Future


/**
  * Created by 212026992 on 12/9/2016.
  */
class TitleServiceImpl extends TitleService with Service{



  override def createOrUpdate(title: Title): Future[ResultSet] = {
    TitleRepository.save(title)
  }

  def getTitleById(id: String): Future[Option[Title]] = {
    TitleRepository.getTitleById(id)
  }

  def getAllTitle(): Future[Seq[Title]] = {
    TitleRepository.getAllTitle
  }

  def deleteById(id: String): Future[ResultSet] = {
    TitleRepository.deleteById(id)
  }
}