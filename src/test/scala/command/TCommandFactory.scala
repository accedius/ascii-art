package command

import io.client.command.CommandSeq
import io.client.parser.CommandParser

trait TCommandFactory {
  protected def makeParsedCommands(arguments: Seq[String]): CommandSeq = {
    CommandParser.parse(arguments)
  }
}
