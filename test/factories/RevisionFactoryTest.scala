package factories

import org.scalatest.FunSuite

import scala.collection.mutable

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class RevisionFactoryTest extends FunSuite{

  test("testCreateRevision") {

    val changes = mutable.MutableList[Object]()

    val values= Map("revisionId"-> "12345678","date" ->"28/12/2016","changes"->changes)
    val revision = RevisionFactory.createRevision(values)
    assert(revision == revision(revisionId="12345678",date ="28/12/2016",change=changes))

  }
}
