package com.softwaremill.gatling.zeromq.action

import com.softwaremill.gatling.zeromq.request.builder.ZmqRequest
import io.gatling.core.CoreComponents
import io.gatling.core.action.Action
import io.gatling.core.session.Session
import io.gatling.commons.util.Clock
import org.zeromq.ZMQ

class ZmqReqAction(sock: ZMQ.Socket,
                   request: ZmqRequest,
                   coreComponents: CoreComponents,
                   throttled: Boolean,
                   next: Action,
                   clock: Clock)
    extends ZmqAction(sock, request, coreComponents, throttled, next, clock) {

  override val name: String = genName("zmqReq")

  override protected def doSend(session: Session,
                                requestName: String,
                                payloads: List[Any]): Boolean = {
    val isEverythingSent = super.doSend(session, requestName, payloads)
    if (isEverythingSent) sock.recvStr()
    isEverythingSent
  }

}
