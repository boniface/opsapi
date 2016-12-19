package services

import domain.Award
import services.impl.AwardServiceImpl

/**
  * Created by Administrator on 12/14/2016.
  */
trait AwardServices
{
  def createOrUpdate(award: Award):Future[ResultSet]
  def getAwardById(id: String):Future[Option[Award]]
  def getAllAwards():Future[Seq[Award]]
}
object AwardServices
{
  def apply: AwardServices = new AwardServiceImpl()
}

