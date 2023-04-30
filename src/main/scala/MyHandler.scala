package com.example

import com.amazonaws.services.lambda.runtime.{
  Context, RequestHandler
}
import com.amazonaws.services.lambda.runtime.events.{
  APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent
}

class MyHandler
    extends RequestHandler[APIGatewayProxyRequestEvent,APIGatewayProxyResponseEvent]:
  override def handleRequest(
    input: APIGatewayProxyRequestEvent, context: Context
  ): APIGatewayProxyResponseEvent =
    val statusCode: Int = input.getPath match
      case "/gimmeOK"             => 200
      case "/gimmeCreated"        => 201
      case "/gimmeNotImplemented" => 501
      case _                      => 404
    new APIGatewayProxyResponseEvent()
      .withStatusCode(statusCode)
      .withBody(s"Thank you for your request 😄\nPlease enjoy this response code $statusCode\n")
