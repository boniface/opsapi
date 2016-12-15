package repositories

import domain.Question

/**
  * Created by Administrator on 12/14/2016.
  */
class QuestionRepository extends CassandraTable[QuestionRepository, Question] {

  object id extends StringColumn(this) with PartitionKey[SerialVersionUID]

  object author extends Organization(this)

  object title extends StringColumn(this)

  object description extends Value(this)

  object date extends StringColumn(this)

  object dateAnswered extends StringColumn(this)

  object answer extends StringColumn(this)

  object questionOf extends StringColumn(this)

  object relatedItem extends StringColumn(this)

  override def fromRow(r: Row): Question = Question(id(r), author(r), title(r), description(r), date(r), dateAnswered(r), answer(r), questionOf(r), relatedItem(r))
}

object QuestionRepository extends QuestionRepository with RootConnector {
  override lazy val tableName = "question"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(question: Question): Future[ResultSet] = {
    insert
      .value(_.id, question.id)
      .value(_.author, question.author)
      .value(_.title, question.title)
      .value(_.description, question.description)
      .value(_.date, question.date)
      .value(_.dateAnswered, question.dateAnswered)
      .value(_.answer, question.answer)
      .value(_.questionOf, question.questionOf)
      .value(_.relatedItem, question.relatedItem)
      .future()
  }

  def getQuestionById(id: String): Future[Option[Question]] = {
    select.where(_.id eqs id).one()
  }

  def getAllQuestions: Future[Seq[Question]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getQuestion(id: String): Future[Seq[Question]] = {
    select.where(_.id eqs id).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(id: String): Future[ResultSet] = {
    delete.where(_.id eqs id).future()
  }
}

