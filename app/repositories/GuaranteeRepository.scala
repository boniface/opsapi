package repositories

import com.datastax.driver.core.Row
import com.websudos.phantom.CassandraTable
import com.websudos.phantom.dsl._
import com.websudos.phantom.keys.PartitionKey
import com.websudos.phantom.reactivestreams._
import conf.DataConnection
import domain.Guarantee

import scala.concurrent.Future

/**
  * Created by Mzuvukile Lawana on 2016/12/01.
  */
sealed class GuaranteeRepository extends CassandraTable[GuaranteeRepository,Guarantee] {

  object guaranteeId extends StringColumn(this) with PartitionKey[String]
  object amount extends FloatColumn(this)
  object currency extends StringColumn(this)

  override def fromRow(r: Row): Guarantee = {
    Guarantee(guaranteeId(r),amount(r),currency(r))
  }

  object GuaranteeRepository extends GuaranteeRepository with RootConnector {
    override lazy val tableName = "guarantee"

    override implicit def space: KeySpace = DataConnection.keySpace

    override implicit def session: Session = DataConnection.session

    def save(guarantee: Guarantee): Future[ResultSet] = {
      insert
        .value(_.guaranteeId, guarantee.guaranteeId)
        .value(_.amount, guarantee.amount)
        .value(_.currency, guarantee.currency)
        .future()
    }

    def getGuaranteeById(guaranteeId: String): Future[Option[Guarantee]] = {
      select.where(_.guaranteeId eqs guaranteeId).one()
    }

    def findAll: Future[Seq[Guarantee]] = {
      select.fetchEnumerator() run Iteratee.collect()
    }
    def getGuarantee(guaranteeId: String): Future[Seq[Guarantee]] = {
      select.where(_.guaranteeId eqs guaranteeId).fetchEnumerator() run Iteratee.collect()
    }

    def deleteById(guaranteeId: String): Future[ResultSet] = {
      delete.where(_.guaranteeId eqs guaranteeId).future()
    }

  }
}
