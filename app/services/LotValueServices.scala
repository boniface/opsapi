package services

import domain.LotValue
import services.impl.LotValueServiceImpl

/**
  * Created by Administrator on 12/14/2016.
  */
trait LotValueServices {
  def createOrUpdate(lotValueServices: LotValueServices):Future[ResultSet]
  def getLotValueById(value: Value):Future[Option[LotValue]]
  def getAllLotValues():Future[Seq[LotValue]]
}
object LotValueServices
{
  def apply: LotValueServices = new LotValueServiceImpl()
}

