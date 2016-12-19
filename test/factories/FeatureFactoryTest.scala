package factories

import org.scalatest.FunSuite
import factories.FeatureFactory

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class FeatureFactoryTest extends FunSuite{

  test("testCreateFeature") {

    val values= Map("featureId"->"1234","code"->"#1234","featureOf" ->"featureOf","relatedItem"->"relatedItem",
      "title" ->"title","description" ->"A description")
    val feature = FeatureFactory.createFeature(values)

    assert (feature == feature(featureId="1234",code="#1234",featureOf =featureOf,relatedItem=relatedItem,
      title ="title",description ="A description"))

  }
}
