package factories

import domain.{Unit}

/**
  * Created by AidenP on 2016/11/23.
  */
class UnitFactory {

  def createUnit(values: Map[String,String]):Unit={Unit(
    code = values("code"),
    name = values("name")
  )}
}
