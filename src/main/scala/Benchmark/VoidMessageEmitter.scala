package Benchmark

import nu.validator.messages.MessageEmitter
import nu.validator.messages.types.MessageType

object VoidMessageEmitter extends MessageEmitter {
  def startMessage(`type`: MessageType, systemId: String, oneBasedFirstLine: Int, oneBasedFirstColumn: Int, oneBasedLastLine: Int, oneBasedLastColumn: Int, exact: Boolean): Unit = ()

  def endMessage(): Unit = ()
}
