package repositories

import domain.Parameter

/**
  * Created by Administrator on 12/14/2016.
  */
class ParameterRepository extends CassandraTable[ParameterRepository, Parameter] {

  object code extends StringColumn(this) with PartitionKey[String]

  object value extends Float(this)

  override def fromRow(r: Row): Parameter = Parameter(code(r), value(r))
}

object ParameterRepository extends ParameterRepository with RootConnector {
  override lazy val tableName = "parameter"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(parameter: Parameter): Future[ResultSet] = {
    insert
      .value(_.code, parameter.code)
      .value(_.value, parameter.value)
      .future()
  }

  def getParameterById(code: String): Future[Option[Parameter]] = {
    select.where(_.code eqs code).one()
  }

  def getAllParameters: Future[Seq[Parameter]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getParameter(code: String): Future[Seq[Parameter]] = {
    select.where(_.code eqs code).fetchEnumerator() run Iteratee.collect()
  }

  def deleteById(code: String): Future[ResultSet] = {
    delete.where(_.code eqs code).future()
  }
}

}
