package domain
import play.api.libs.json.Json
/**
  * Created by sanXion on 2016/11/24.
  */
class Value(amount : Float,
            currency : String,
            valueAddedTaxIncluded :  Boolean)

object Value{
  implicit val valueFmt = Json.format[Value]
}
