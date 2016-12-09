package services.Lot

import com.websudos.phantom.dsl._
import domain.Lot.LotValues
import io.netty.util.concurrent.Future
import services.Lot.Impl.LotValuesServiceImpl

/**
  * Created by AidenP on 2016/12/07.
  */
trait LotValuesService {
  def createOrUpdate(lotValues: LotValues): Future[ResultSet]

  def getLotValuesById(lotId: String, valueId: String): Future[Option[LotValues]]

  def deleteById(lotId: String, valueId: String): Future[ResultSet]

  def getAllLotValuess(): Future[Seq[LotValues]]

}
object LotValuesService{
  def apply: LotValuesService = new LotValuesServiceImpl()
}