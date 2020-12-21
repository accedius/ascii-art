package Main

import io.client.parser.CommandParser
import io.client.CommandHandler

object Main extends App {
  try {
    val commands = CommandParser.parse(args)
    CommandHandler(commands).run
  } catch {
    case thrown: Throwable => {
      println(thrown.getMessage)
      thrown.printStackTrace()
    }
  }
}