package factories

import domain.Question

/**
  * Created by Administrator on 12/11/2016.
  */
class QuestionFactory
{
  def createQuestion(values: Map[String, String], id:SerialVersionUID, author:Organization): Question =
  {
    Question(id = id, author = author, title = values("title"), description = values("description"), answer = values("answer"), questionOf = values("questionOf"), relatedItem = values("relatedItem"))
  }

}
