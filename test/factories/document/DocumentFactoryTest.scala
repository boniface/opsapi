package factories.document

import domain.Document.Document
import factories.Document.DocumentFactory
import org.scalatest.FunSuite

/**
  * Created by AidenP on 2016/12/13.
  */
class DocumentFactoryTest extends FunSuite {
  test("testCreateDocument"){
    val document = new DocumentFactory

    val values = Map("id" -> "1",
      "title" -> "test",
      "description" -> "test",
      "format" -> "test",
      "url" -> "www.test.co.za",
      "datePublished" -> "test",
      "dateModified" -> "test",
      "language" -> "test",
      "documentOf" -> "test",
      "relatedItem" -> "test"
    )

    val docType = Map("notice" -> "test",
      "biddingDocuments" -> "test",
      "technicalSpecifications" -> "test",
      "evaluationCriteria" -> "test",
      "clarifications" -> "test",
      "eligibilityCriteria" -> "test",
      "shortlistedFirms" -> "test",
      "riskProvisions" -> "test",
      "billOfQuantity" -> "test",
      "bidders" -> "test",
      "conflictOfInterest" -> "test",
      "debarments" -> "test",
      "contractProforma" -> "test")

    val doc = document.createDocument(values,docType)

    assert(doc == Document(id = "1",
      documentType = Map("notice" -> "test",
        "biddingDocuments" -> "test",
        "technicalSpecifications" -> "test",
        "evaluationCriteria" -> "test",
        "clarifications" -> "test",
        "eligibilityCriteria" -> "test",
        "shortlistedFirms" -> "test",
        "riskProvisions" -> "test",
        "billOfQuantity" -> "test",
        "bidders" -> "test",
        "conflictOfInterest" -> "test",
        "debarments" -> "test",
        "contractProforma" -> "test"),
      title = "test",
      description = "test",
      format = "test",
      url = "test",
      datePublished = "test",
      dateModified = "test",
      language = "test",
      documentOf = "test",
      relatedItem = "test"))
  }
}

