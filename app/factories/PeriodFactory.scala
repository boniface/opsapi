package factories

import domain.Period.Period

/**
  * Created by sanXion on 2016/12/11.
  */
class PeriodFactory {
  def createPeriod(values:Map[String, String]):Period={
    Period(startDate = values("startDate"),
      endDate = values("endDate"))
  }
}
