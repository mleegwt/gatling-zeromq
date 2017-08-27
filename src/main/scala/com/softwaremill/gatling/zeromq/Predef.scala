package com.softwaremill.gatling.zeromq

import com.softwaremill.gatling.zeromq.protocol.{SenderType, ZmqProtocolBuilder}
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.session.Expression

object Predef {

  def zmqConfig(implicit configuration: GatlingConfiguration) =
    ZmqProtocolBuilder(configuration)

  def zmqPublish(requestName: Expression[String]) =
    new Zmq(requestName, SenderType.PUB)

}
