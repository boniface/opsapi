package factories

import domain.Parameter

/**
  * Created by Administrator on 12/11/2016.
  */
class ParameterFactory
{
  def createParameter(code:String, value:Float): Parameter =
  {
    Parameter(code = code, value = value)
  }

}
