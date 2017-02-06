package com.twitter.finagle.buoyant.msgpack

class RpcException(message: String, reason: Throwable) extends RuntimeException(message, reason) {
  def this(message: String) = this(message, null)
}
