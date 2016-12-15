package services

import conf.DataConnection

/**
  * Created by AidenP on 2016/12/07.
  */
trait Service {
  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session
}
