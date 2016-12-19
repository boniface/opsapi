package services.impl

import domain.LotValue
import repositories.LotValueRepository
import services.{LotValueServices, Service}

/**
  * Created by Administrator on 12/14/2016.
  */
class LotValueServiceImpl extends LotValueServices with Service
{
  override def createOrUpdate(lotValue: LotValue): Future[ResultSet] =
  {
    LotValueRepository.save(lotValue)
  }
  override def getLotValueById(value: Value): Future[Option[LotValue]] =
  {
    LotValueRepository.getLotValueById(value)
  }

  override def getAllLotValues(): Future[Seq[LotValue]] =
  {
    LotValueRepository.getAllLotValues
  }
}
