package factories

import domain.{Contract, Document, Item, Organization}
import domain.Period.Period
import domain.Value.Value

/**
  * Created by sanXion on 2016/12/11.
  */
class ContractFactory {
  def createContract(values:Map[String, String], period : Period, value : Value , item :List[Item], organization :List[Organization], document :List[Document]):Contract={
    Contract(id = values("id"),
              awardID = values("awardID"),
              contractID = values("contractID"),
              contractNumber = values("contractNumber"),
              title = values("title"),
              description = values("description"),
              value = value,
              items = item,
              suppliers = organization,
              status = values("status"),
              period = period,
              dateSigned = values("dateSigned"),
              date = values("date"),
              documents = document)
  }
}