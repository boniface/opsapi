package services.Title.Impl

import com.websudos.phantom.dsl.ResultSet
import domain.Title
import repositories.TitleRepository
import services.Service
import services.Title.TitleService

import scala.concurrent.Future

/**
  * Created by 212026992 on 2016/11/02.
  */
class TitleServiceImpl extends TitleService with Service{
  override def createOrUpdate(identifier: Title): Future[ResultSet] = {
    TitleRepository.save(identifier)
  }

  override def getTitleById(title: String): Future[Option[Title]] = {
    TitleRepository.getTitleById(title)
  }

  override def getTitles(title: String): Future[Seq[Title]] = {
    TitleRepository.getTitles(title)
  }
}
