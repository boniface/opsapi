package factories.classification

import domain.Classification.Classification
import factories.Classification.ClassificationFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class ClassificationFactoryTest extends FunSuite {
  test("testCreateClassification"){
    val classification = new ClassificationFactory

    val values = Map("scheme" -> "test",
      "id" -> "1",
      "description" -> "test",
      "uri" -> "test"
    )

    val classi = classification.createClassification(values)

    assert(classi == Classification(scheme = "test",
      id = "1",
      description = "test",
      uri = "test"))
  }
}