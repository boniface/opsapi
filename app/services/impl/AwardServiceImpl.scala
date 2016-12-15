package services.impl

import domain.Award
import repositories.AwardRepository
import services.{AwardServices, Service}
/**
  * Created by Administrator on 12/14/2016.
  */
class AwardServiceImpl extends AwardServices with Service
{
  override def createOrUpdate(award: Award): Future[ResultSet] =
  {
    AwardRepository.save(award)
  }
  override def getAwardById(id: String): Future[Option[Award]] =
  {
    AwardRepository.getAwardById(id)
  }

  override def getAllAwards(): Future[Seq[Award]] =
  {
    AwardRepository.getAllAwards
  }
}