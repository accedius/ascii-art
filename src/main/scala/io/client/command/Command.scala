package io.client.command

/**
 * Command storing class
 * @param name - name of the command
 * @param parameter - optional parameter for the command
 */
case class Command (name: String, parameter: Option[String] = Option.empty) {
  def getParameter: String = parameter.getOrElse(throw new IllegalArgumentException("Command " + name + " should have one argument!"))

  override def equals(o: Any): Boolean = {
    if(!o.isInstanceOf[Command]) return false

    val other: Command = o.asInstanceOf[Command]
    this.name == other.name
  }

  override def hashCode(): Int = name.hashCode
}
