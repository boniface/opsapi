package services.impl

import domain.Question
import repositories.QuestionRepository
import services.{QuestionServices, Service}

/**
  * Created by Administrator on 12/14/2016.
  */
class QuestionServiceImpl extends QuestionServices with Service
{
  override def createOrUpdate(question : Question): Future[ResultSet] =
  {
    QuestionRepository.save(question)
  }
  override def getQuestionById(id: String): Future[Option[Question]] =
  {
    QuestionRepository.getQuestionById(id)
  }

  override def getAllQuestions(): Future[Seq[Question]] =
  {
    QuestionRepository.getAllQuestions
  }
}
