package repositories

import domain.Feature
import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
  * Created by Mzuvukile Lawana on 2016/12/12.
  */
class FeatureRepositoryTest extends FeatureSpec with GivenWhenThen{

  feature("Create feature") {
    info("Add an feature")
    scenario("Add new feature ") {
      Given("Given all data")
      val featureId = "123456"
      val code = "code"
      val featureOf = "featureOf"
      val relatedItem = "relatedItem"
      val title = "title"
      val description = "description"
      val enum = "featurevalue"

      Then("Add feature ")
      val feature = Feature(featureId, code, featureOf, relatedItem, title, description, enum)
      val featureRepo = FeatureRepository
      featureRepo.save(feature)
      Then("Display All ")
      val displayAllcancelled = Await.result(featureRepo.getFeatureById(featureId), 2 minutes)
      displayAllfeature.foreach(i => println("Feature=======>", i))
      val displayIdStatus = Await.result(featureRepo.getFeatureById(featureId), 2 minutes)
      displayIdStatus.foreach(i => println("FeatureStatus=======>", i))
    }
    }
  }
