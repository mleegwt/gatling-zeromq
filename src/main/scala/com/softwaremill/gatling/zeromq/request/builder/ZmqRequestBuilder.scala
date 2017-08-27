package com.softwaremill.gatling.zeromq.request.builder

import com.softwaremill.gatling.zeromq.action.ZmqSendActionBuilder
import com.softwaremill.gatling.zeromq.protocol.SenderType.SenderType
import io.gatling.core.session.Expression

class ZmqRequestBuilder(requestName: Expression[String],
                        val senderType: SenderType,
                        payloads: List[Expression[Any]]) {

  def toActionBuilder(): ZmqSendActionBuilder =
    new ZmqSendActionBuilder(this)

  def build(): ZmqRequest = ZmqRequest(requestName, payloads)

}
