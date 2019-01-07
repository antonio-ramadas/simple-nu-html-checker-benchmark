import java.io.StringReader

import scala.util.Try

import nu.validator.messages.types.MessageType
import nu.validator.messages.{MessageEmitter, MessageEmitterAdapter}
import nu.validator.validation.SimpleDocumentValidator
import org.xml.sax.helpers.DefaultHandler
import org.xml.sax.InputSource

object VoidMessageEmitter extends MessageEmitter {
  def startMessage(`type`: MessageType, systemId: String, oneBasedFirstLine: Int, oneBasedFirstColumn: Int, oneBasedLastLine: Int, oneBasedLastColumn: Int, exact: Boolean): Unit = ()

  def endMessage(): Unit = ()
}

case class NuHtmlChecker() {
  val schemaUrl = "http://s.validator.nu/html5-rdfalite.rnc"

  val validator = new SimpleDocumentValidator(true, false, true)

  // setup
  val errorHandler: MessageEmitterAdapter = getErrorHandler(validator)
  errorHandler.setHtml(true)
  errorHandler.start(null)
  validator.setAllowCss(true)

  // setSchema
  validator.setUpMainSchema(schemaUrl, new DefaultHandler())
  validator.setUpValidatorAndParsers(errorHandler, false, false)

  def isValidHtmlBody(htmlBody: String): Boolean = {
    val html =
      s"""
         |<!DOCTYPE html>
         |<html lang="">
         | <head>
         |   <title>Title must not be empty</title>
         | </head>
         | <body>
         |   $htmlBody
         | </body>
         |</html>
       """.stripMargin

    Try { validator.checkHtmlInputSource(new InputSource(new StringReader(html))) }
      .map(_ => errorHandler.getErrors == 0 && errorHandler.getFatalErrors == 0)
      .recover{ case _ => false }
      .get

    // errorHandler.end("Success!", "The document probably has some errors", "")
  }

  private def getErrorHandler(validator: SimpleDocumentValidator): MessageEmitterAdapter = {
    val errorHandler = new MessageEmitterAdapter(null, validator.getSourceCode,
      false, null, 0, true, VoidMessageEmitter)

    errorHandler.setErrorsOnly(false)

    errorHandler
  }
}

object NuHtmlChecker {
  val validBody: String =
    """
      |<p>This is a valid body!</p>
    """.stripMargin('|')

  val invalidBody: String =
    """
      |Missing opening tag.</p>
    """.stripMargin('|')
}

object Benchmark {
  def main(args: Array[String]): Unit = {
    val htmlChecker = NuHtmlChecker()

    println(htmlChecker.isValidHtmlBody(NuHtmlChecker.validBody))
    println(htmlChecker.isValidHtmlBody(NuHtmlChecker.invalidBody))
  }
}
