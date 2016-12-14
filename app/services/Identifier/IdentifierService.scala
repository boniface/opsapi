package services.Identifier
import com.websudos.phantom.dsl._
import domain.Identifier
import io.netty.util.concurrent.Future
import services.Identifier.Impl.IdentifierServiceImpl
/**
  * Created by 212026992 on 12/9/2016.
  */
trait IdentifierService {



  def createOrUpdate(identifier: Identifier): Future[ResultSet]

  def getIdentifierById(id: String): Future[Option[Identifier]]

  def deleteById(id: String): Future[ResultSet]

  def getAllIdentifier(): Future[Seq[Identifier]]

}
object IdentifierService{
  def apply: IdentifierService = new IdentifierServiceImpl()

}