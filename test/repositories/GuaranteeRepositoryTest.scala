package repositories

import domain.Guarantee
import org.scalatest.{FeatureSpec, GivenWhenThen}

import scala.concurrent.Await

/**
  * Created by Mzuvukile Lawana on 2016/12/12.
  */
class GuaranteeRepositoryTest extends FeatureSpec with GivenWhenThen{

  feature("Create guarantee") {
    info("Add guarantee")
    scenario("Add new guarantee ") {
      Given("Given all data")
      val guaranteeId = "12345678"
      val amount = 120000
      val currency = "US"

      Then("Add guarantee ")
      val guarantee = Guarantee(guaranteeId, amount, currency)
      val guaranteeRepo = GuaranteeRepository
      guaranteeRepo.save(guarantee)
      Then("Display All ")
      val displayAllGuarantee = Await.result(guaranteeRepo.getGuaranteeById(guaranteeId), 2 minutes)
      displayAllGuarantee.foreach(i => println("Guarantee=======>", i))
      val displayIdStatus = Await.result(guaranteeRepo.getGuaranteeById(guaranteeId), 2 minutes)
      displayIdStatus.foreach(i => println("GuaranteeStatus=======>", i))
    }
  }
}
