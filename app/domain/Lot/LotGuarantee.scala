package domain.Lot

import play.api.libs.json.Json

/**
  * Created by AidenP on 2016/11/30.
  */
case class LotGuarantee (LotId:String,
                         GuaranteeId:String

)

object LotGuarantee{
  implicit val lotGuaranteeFmt = Json.format[LotGuarantee]
}
