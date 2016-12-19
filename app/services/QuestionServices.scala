package services

import domain.Question
import services.impl.QuestionServiceImpl

/**
  * Created by Administrator on 12/14/2016.
  */
trait QuestionServices {
  def createOrUpdate(question: Question):Future[ResultSet]
  def getQuestionById(id: String):Future[Option[Question]]
  def getAllQuestions():Future[Seq[Question]]
}
object QuestionServices
{
  def apply: QuestionServices = new QuestionServiceImpl()
}
