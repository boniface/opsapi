package factories.Unit

import domain.Unit.Unit

/**
  * Created by AidenP on 2016/11/23.
  */
class UnitFactory {

  def createUnit(values: Map[String,String]):

  Unit={domain.Unit.Unit(
    code = values("code"),
    name = values("name")
  )}
}
