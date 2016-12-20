package services.Value

import com.websudos.phantom.dsl._
import domain.Value.Value
import services.Value.Impl.ValueServiceImpl

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/19.
  */
trait ValueService {
  def createOrUpdate(value: Value): Future[ResultSet]

  def getValueByCurrency(currency: String): Future[Seq[Value]]

  def deleteByCurrency(currency: String): Future[ResultSet]

  def getAllValues(): Future[Seq[Value]]

}
object ValueService{
  def apply: ValueService = new ValueServiceImpl()
}