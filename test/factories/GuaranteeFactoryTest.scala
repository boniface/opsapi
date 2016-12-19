package factories

import org.scalatest.FunSuite

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class GuaranteeFactoryTest extends FunSuite{

  test("testCreateGuarantee") {

    val values= Map("guaranteeId"-> "1234567","amount" ->1234,"currency"->"US")
    val guarantee = GuaranteeFactory.createGuarantee(values)
    assert(guarantee == guarantee(guaranteeId= "1234567",amount =1234,currency="US"))

  }
}
