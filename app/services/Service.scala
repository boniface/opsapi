package services
<<<<<<< HEAD
import conf.connection.DataConnection
/**
  * Created by 212026992 on 12/9/2016.
  */



trait Service {
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session
=======

import conf.DataConnection

/**
  * Created by Mzuvukile Lawana on 2016/12/11.
  */
trait Service {

  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

>>>>>>> c93555dc485c1c2f2584037488008fbec01cb6cd
}
