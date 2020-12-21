package io.client.command

case class CommandSeq(commands: Seq[Command]) {
  def find(command: Command => Boolean): Option[Command] = commands.find(command)
}
