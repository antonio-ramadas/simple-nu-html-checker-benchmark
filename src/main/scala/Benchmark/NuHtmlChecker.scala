package Benchmark

import java.io.StringReader

import scala.util.Try

import nu.validator.messages.MessageEmitterAdapter
import nu.validator.validation.SimpleDocumentValidator
import org.xml.sax.InputSource
import org.xml.sax.helpers.DefaultHandler

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

  def isValidHtmlBody(htmlBody: String = ""): Boolean = {
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
