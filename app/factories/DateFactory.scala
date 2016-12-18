package factories

import domain.Date.Date

/**
  * Created by sanXion on 2016/12/11.
  */
class DateFactory {
  def createDate(date : String):Date={
    Date(date = date)
  }
}