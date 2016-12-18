package factories

import domain.Title

/**
  * Created by 212026992 on 12/3/2016.
  */
class TitleFactory {
  def createTitle(values: Map[String,String]
               ):Title={
    Title(
      tenderCode = values("tenderCode"),
      periodicityOfTheTender = values("periodicityOfTheTender"),
      itemBeingProcured = values("itemBeingProcured"))

  }
}
