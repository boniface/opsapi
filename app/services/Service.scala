package services

import conf.DataConnection

/**
  * Created by travis on 2016/12/11.
  */
trait Service {

  implicit val keyspace = DataConnection.keySpace
  implicit val session = DataConnection.session

}
