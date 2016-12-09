package services
import conf.connection.DataConnection
/**
  * Created by 212026992 on 12/9/2016.
  */



trait Service {
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session
}
