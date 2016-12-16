package factories

import domain.Revision

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
class RevisionFactory {

  def createRevision(values:Map[String, String],changes: List[Object]):Revision={
    Revision(revisionId = values("revisionId"),
      date = values("date"),
      changes = changes)
  }

}
