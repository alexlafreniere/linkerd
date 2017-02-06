package com.twitter.finagle.buoyant.msgpack

/**
 * @author Dmitri Babaev (dmitri.babaev@gmail.com)
 */
class RpcException(message: String, reason: Throwable) extends RuntimeException(message, reason) {
  def this(message: String) = this(message, null)
}
