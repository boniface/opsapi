package services.Identifier

import com.websudos.phantom.dsl._
import domain.Identifier
import services.Identifier.Impl.IdentifierServiceImpl
import scala.concurrent.Future

/**
  * Created by 212026992 on 2016/11/02.
  */
trait IdentifierService {
  def createOrUpdate(addressType:Identifier):Future[ResultSet]

  def getIdentifierById(addressType: String): Future[Option[Identifier]]

  def getIdentifiers(addressType: String): Future[Seq[Identifier]]
}

object IdentifierService{
  def apply: IdentifierService = new IdentifierServiceImpl()
}