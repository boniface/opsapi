package repositories

import domain.Cancellation
import org.scalatest.{FeatureSpec, GivenWhenThen}
import repositories.CancellationRepository

import scala.concurrent.Await

/**
  * Created by Mzuvukile Lawana on 2016/12/12.
  */
class CancellationRepositoryTest extends FeatureSpec with GivenWhenThen {

  feature("Create cancellation") {
    info("Add an cancellation")
    scenario("Add new cancellation ") {
      Given("Given cancellationId,reason,date,status,document,cancellationOf,relatedLot")
      val cancellationId = "12345"
      val reason = "Nothing"
      val date = "26/18/12"
      val status = "Done"
      val documents = "Documnets"
      val cancellationOf = "Bond"
      val relatedLot = "related"

      Then("Add cancellation ")
      val cancellation = Cancellation(cancellationId,reason,date,status,documents,cancellationOf,cancellationOf,relatedLot)
      val cancellationRepo = CancellationRepository
      cancellationRepo.save(cancellation)
      Then("Display All ")
      val displayAllcancelled = Await.result(cancellationRepo.getCancellationById(cancellationId), 2 minutes)
      displayAllcancelled.foreach(i => println("Cancellation=======>", i))
      val displayIdStatus = Await.result(cancellationRepo.getCancellationById(cancellationId), 2 minutes)
      displayIdStatus.foreach(i => println("CancellationStatus=======>", i))
    }
  }

}
