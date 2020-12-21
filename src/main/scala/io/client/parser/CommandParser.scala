package io.client.parser

import io.client.command.{Command, CommandSeq}

object CommandParser {
  def parse(arguments: Seq[String]): CommandSeq = {
    val commandList: Seq[Command] = nextCommand(arguments)
    CommandSeq(commandList)
  }

  private def nextCommand(arguments: Seq[String]): Seq[Command] = {
    if(arguments.isEmpty) return List()

    var commandStr: String = arguments.head
    checkCommand(commandStr)

    var nextArguments = arguments.tail
    var commandParameter: Option[String] = Option.empty

    if(isArgumentCommand(commandStr)) {
      if(arguments.tail.isEmpty) throw new IllegalArgumentException("No argument for command \"" + commandStr + "\"")

      val parameter = arguments.tail.head
      checkParameter(commandStr, parameter)
      nextArguments = arguments.tail.tail
      commandParameter = Option(parameter)
    }

    val commandSequence: Seq[Command] = nextCommand(nextArguments)

    //drops first two letters containing "--"
    val commandName = commandStr.drop(2)

    val command = Command(commandName, commandParameter)
    if(commandSequence.contains(command)) {
      throw new IllegalArgumentException("Command \"" + commandStr + "\" is defined more than once!")
    }

    command +: commandSequence
  }

  private def checkCommand(commandName: String) = {
    if(!isCommand(commandName)) {
      throw new IllegalArgumentException("Command \"" + commandName + "\" is not valid. Available commands: " + availableCommands.mkString(", "))
    }
  }

  private def checkParameter(commandName: String, argument: String): Unit = {
    if(argument.isEmpty || isCommand(argument)) {
      throw new IllegalArgumentException("Argument \"" + argument + "\" is not valid for command \"" + commandName + "\". Available commands: " + availableCommands.mkString(", "))
    }
  }

  private def isCommand(str: String): Boolean = {
    availableCommands.contains(str)
  }

  def availableCommands: Set[String] = Set("--image", "--output-file", "--output-console")

  private def isArgumentCommand(commandName: String): Boolean = {
    argumentCommands.contains(commandName)
  }

  private def argumentCommands = Set("--image", "--output-file")
}
