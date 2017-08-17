package com.softwaremill.zeromq.protocol

import akka.actor.ActorSystem
import io.gatling.core.CoreComponents
import io.gatling.core.config.GatlingConfiguration
import io.gatling.core.protocol.{Protocol, ProtocolKey}

object ZmqProtocol {

  def apply(configuration: GatlingConfiguration): ZmqProtocol = ZmqProtocol(
    host = "localhost",
    port = ""
  )

  val ZmqProtocolKey = new ProtocolKey {

    type Protocol = ZmqProtocol
    type Components = ZmqComponents

    def protocolClass: Class[io.gatling.core.protocol.Protocol] =
      classOf[ZmqProtocol]
        .asInstanceOf[Class[io.gatling.core.protocol.Protocol]]

    def defaultProtocolValue(configuration: GatlingConfiguration): ZmqProtocol =
      ZmqProtocol(configuration)

    def newComponents(
        system: ActorSystem,
        coreComponents: CoreComponents): ZmqProtocol => ZmqComponents = {
      zmqProtocol =>
        ZmqComponents(zmqProtocol)
    }
  }
}

case class ZmqProtocol(host: String, port: String) extends Protocol {

  def host(host: String): ZmqProtocol = copy(host = host)
  def port(port: String): ZmqProtocol = copy(port = port)

}
