package com.twitter.finagle.buoyant.msgpack

import java.lang.reflect.Method
import java.security.MessageDigest

object MethodSignature {
  def generate(m: Method) = {
    val digest = MessageDigest.getInstance("MD5")
    digest.update(m.getName.getBytes)
    m.getParameterTypes.foreach { t =>
      digest.update(t.getName.getBytes)
    }
    digest.digest().map("%02x".format(_)).mkString
  }
}
