package services

import domain.{Bid, Parameter}
import services.impl.ParameterServiceImpl

/**
  * Created by Administrator on 12/14/2016.
  */
trait ParameterServices {
  def createOrUpdate(parameter: Parameter):Future[ResultSet]
  def getParameterById(code: String):Future[Option[Parameter]]
  def getAllParameters():Future[Seq[Parameter]]
}
object ParameterServices
{
  def apply: ParameterServices = new ParameterServiceImpl()
}
