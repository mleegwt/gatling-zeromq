package com.softwaremill.zeromq

import com.softwaremill.zeromq.protocol.ZmqProtocolBuilder
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.session.Expression

object Predef {

  def zmqConfig(implicit configuration: GatlingConfiguration) =
    ZmqProtocolBuilder(configuration)

  def zmq(requestName: Expression[String]) = new Zmq(requestName)

}
