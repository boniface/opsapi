package repositories

import domain.{Revision}
import org.scalatest.{FeatureSpec, GivenWhenThen}

import scala.collection.mutable
import scala.concurrent.Await

/**
  * Created by Mzuvukile Lawana on 2016/12/12.
  */
class RevisionRepositoryTest extends FeatureSpec with GivenWhenThen{

  feature("Create revision") {
    info("Add revision")
    scenario("Add new revision ") {
      Given("Given all data")
      val revisionId = "12345678"
      val date = "25/12/2016"
      val changes = mutable.MutableList[Object]()

      Then("Add guarantee ")
      val revision = Revision(revisionId, date, changes)
      val revisionRepo = RevisionRepository
      revisionRepo.save(revision)
      Then("Display All ")
      val displayAllRevision= Await.result(revisionRepo.getGuaranteeById(revisionId), 2 minutes)
      displayAllRevision.foreach(i => println("Revision=======>", i))
      val displayIdStatus = Await.result(revisionRepo.getGuaranteeById(revisionId), 2 minutes)
      displayIdStatus.foreach(i => println("RevisionStatus=======>", i))
    }
  }
}
