package factories

import domain.{Cancellation, Document}

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class CancellationFactory {
  def createCancellation(values:Map[String, String],document :List[Document]):Cancellation={
    Cancellation(id = values("id"),
      reason = values("reason"),
      date = values("String"),
      status = values("status"),
      documents = document,
      cancellationOf = values("cancellationOf"),
      relatedLot = values("relatedLot"))
  }
}


