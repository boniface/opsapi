package factories.Classification

import domain.Classification.Classification

/**
  * Created by AidenP on 2016/11/23.
  */
class ClassificationFactory {

  def createClassification(values: Map[String, String]): Classification=
  {
    Classification(scheme = values("scheme"),
                    id = values("id"),
                    description = values("description"),
                    uri = values("uri"))
  }
}

