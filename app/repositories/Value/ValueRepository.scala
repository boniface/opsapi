package repositories.Value

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.column.PrimitiveColumn
import com.websudos.phantom.dsl._
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Value.Value

import scala.concurrent.Future

/**
  * Created by sanXion on 2016/12/14.
  */
class ValueRepository extends CassandraTable[ValueRepository, Value] {

  object amount extends FloatColumn(this)

  object currency extends StringColumn(this) with PrimaryKey[String] with ClusteringOrder[String] with Descending

  object valueAddedTaxIncluded extends BooleanColumn(this)

  override def fromRow(r: Row): Value = {
    Value(
      amount(r),
      currency(r),
      valueAddedTaxIncluded(r))
  }
}

object ValueRepository extends ValueRepository with RootConnector {
  override lazy val tableName = "values"

  override implicit def space: KeySpace = DataConnection.keySpace

  override implicit def session: Session = DataConnection.session

  def save(value: Value): Future[ResultSet] = {
    insert
      .value(_.amount, value.amount)
      .value(_.currency, value.currency)
      .value(_.valueAddedTaxIncluded, value.valueAddedTaxIncluded)
      .future()
  }

  def getAllValues: Future[Seq[Value]] = {
    select.fetchEnumerator() run Iteratee.collect()
  }

  def getValueByCurrency(currency: String): Future[Seq[Value]] = {
    select.where(_.currency eqs currency)fetchEnumerator() run Iteratee.collect()
  }

  def deleteByCurrency(Currency: String): Future[ResultSet] = {
    delete.where(_.currency eqs Currency).future()
  }

}