package services.impl

import domain.Parameter
import repositories.ParameterRepository
import services.{ParameterServices, Service}

/**
  * Created by Administrator on 12/14/2016.
  */
class ParameterServiceImpl extends ParameterServices with Service
{
  override def createOrUpdate(parameter : Parameter): Future[ResultSet] =
  {
    ParameterRepository.save(parameter)
  }
  override def getParameterById(code: String): Future[Option[Parameter]] =
  {
    ParameterRepository.getParameterById(code)
  }

  override def getAllParameters(): Future[Seq[Parameter]] =
  {
    ParameterRepository.getAllParameters
  }
}

