package Factories
import domain.Organization
import factories.OrganizationFactory
import org.scalatest.FunSuite
/**
  * Created by 212026992 on 12/14/2016.
  */
class OrganizationFactoryTest extends FunSuite {
  test("testCreateOrganization"){
  val organization = new OrganizationFactory

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

  val additionalIdentifiers = Map("notice" -> "test",
  "biddingDocuments" -> "test",
  "technicalSpecifications" -> "test",
  "evaluationCriteria" -> "test")

    val address = Map("streetAddress" -> "test",
      "locality" -> "1",
      "region" -> "test",
      "postalCode" -> "test",
      "countryName" -> "test")

    val contactPoint = Map("name" -> "test",
      "email" -> "1",
      "telephone" -> "test",
      "faxNumber" -> "test",
      "url" -> "test"
    )

  val doc = organization.createOrganization(values,additionalIdentifiers,address,contactPoint)

  assert(doc == Organization(name = "1",
    identifier = "1",
    additionalIdentifiers = Map("notice" -> "test",
  "biddingDocuments" -> "test",
  "technicalSpecifications" -> "test",
  "evaluationCriteria" -> "test"),
    address = Map("streetAddress" -> "test",
      "locality" -> "1",
      "region" -> "test",
      "postalCode" -> "test",
      "countryName" -> "test"),
    contactPoint = Map("name" -> "test",
      "email" -> "1",
      "telephone" -> "test",
      "faxNumber" -> "test",
      "url" -> "test")))
}
}
