package services.Title
import com.websudos.phantom.dsl._
import domain.Title
import io.netty.util.concurrent.Future
import services.Title.Impl.TitleServiceImpl
/**
  * Created by 212026992 on 12/9/2016.
  */
trait TitleService {

  def createOrUpdate(title: Title): Future[ResultSet]

  def getTitleById(id: String): Future[Option[Title]]

  def deleteById(id: String): Future[ResultSet]

  def getAllTitle(): Future[Seq[Title]]

}
object TitleService{
  def apply: TitleService = new TitleServiceImpl()


}
