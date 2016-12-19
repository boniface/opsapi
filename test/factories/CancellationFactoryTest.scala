package factories

import domain.Document
import org.scalatest.FunSuite
import factories.CancellationFactory

import scala.collection.mutable

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class CancellationFactoryTest extends FunSuite{

  test ("testCreateCancellation") {
     val documents = mutable.MutableList[Document]()

      val values= Map("cancellationId"->"12345","reason"->"Hello World","date" -> "28/12/2016","status" ->"Done",
      "documents" -> documents,"cancellationOf" ->"A Bond","relatedLot" ->"related")
      val cancellation = CancellationFactory.createCancellation(values)
      assert (cancellation == cancellation(cancellationId="12345",reason="Hello World",date= "28/12/2016",status ="Done",
        document = documents,cancellationOf ="A Bond",relatedLot ="related"))

  }
}
