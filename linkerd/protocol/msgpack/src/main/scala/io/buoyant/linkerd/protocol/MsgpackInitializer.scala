package io.buoyant.linkerd
package protocol

import com.fasterxml.jackson.annotation.JsonIgnore
import com.twitter.finagle.Path
import io.buoyant.config.Parser
import io.buoyant.router.{Msgpack, RoutingFactory}

class MsgpackInitializer extends ProtocolInitializer.Simple {
  val name = "msgpack"

  protected type Req = com.twitter.finagle.msgpack.Request
  protected type Rsp = com.twitter.finagle.msgpack.Response

  protected val defaultRouter = Msgpack.router
    .configured(RoutingFactory.DstPrefix(Path.Utf8(name)))

  protected val defaultServer = Msgpack.server

  override def defaultServerPort: Int = 4141

  val configClass = classOf[MsgpackConfig]
}

object MsgpackInitializer extends MsgpackInitializer

class MsgpackConfig extends RouterConfig {

  var servers: Seq[ServerConfig] = Nil
  var client: Option[ClientConfig] = None

  @JsonIgnore
  override def protocol = MsgpackInitializer
}
