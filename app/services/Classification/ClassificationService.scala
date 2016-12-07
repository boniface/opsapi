package services.Classification

import com.websudos.phantom.dsl._
import domain.Classification.Classification
import io.netty.util.concurrent.Future
import services.Classification.Impl.ClassificationServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait ClassificationService {
  def createOrUpdate(cassification: Classification): Future[ResultSet]

  def getOrganisationAddress(cassification: String): Future[Seq[Classification]]

  def deleteById(cassification: String, organisationAddressId: String): Future[ResultSet]
}
object ClassificationService{
  def apply: ClassificationService = new ClassificationServiceImpl()
}
