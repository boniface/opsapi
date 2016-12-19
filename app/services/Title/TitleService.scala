package services.Title

import com.websudos.phantom.dsl._
import domain.Title


import services.Title.Impl.TitleServiceImpl


import scala.concurrent.Future

/**
  * Created by 212026992 on 2016/11/02.
  */
trait TitleService {
  def createOrUpdate(title:Title):Future[ResultSet]

  def getTitleById(title: String): Future[Option[Title]]

  def getTitles(title: String): Future[Seq[Title]]
}

object TitleService{
  def apply: TitleService = new TitleServiceImpl()
}