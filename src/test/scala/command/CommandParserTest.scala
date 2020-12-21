package command

import io.client.command.{Command, CommandSeq}
import org.scalatest.FunSuite

class CommandParserTest extends FunSuite with TCommandFactory {
  test("Parsing empty array of arguments") {
    assert(makeParsedCommands(Seq.empty) == CommandSeq(Seq.empty))
  }

  test("Parsing invalid command name") {
    assertThrows[IllegalArgumentException](makeParsedCommands(Array("--option",  "one")))
  }

  test("Parsing invalid command parameters - zero") {
    assertThrows[IllegalArgumentException](makeParsedCommands(Array("--image")))
  }

  test("Parsing invalid command parameters - more than needed") {
    assertThrows[IllegalArgumentException](makeParsedCommands(Array("--image", "first.txt", "second.txt")))
  }

  test("Parsing valid commands ending with command") {
    val arguments = ("--image test-image.jpg " +
                     "--output-file ../outputs/output.txt " +
                     "--output-console").split(' ')
    val expected = CommandSeq(Seq(
      Command("image", Option("test-image.jpg")),
      Command("output-file", Option("../outputs/output.txt")),
      Command("output-console")
    ))
    assert(makeParsedCommands(arguments) == expected)
  }

  test("Parsing valid commands ending with parameter") {
    val arguments = ("--image test-image.jpg " +
      "--output-console " +
      "--output-file ../outputs/output.txt").split(' ')
    val expected = CommandSeq(Seq(
      Command("image", Option("test-image.jpg")),
      Command("output-console"),
      Command("output-file", Option("../outputs/output.txt"))
    ))
    assert(makeParsedCommands(arguments) == expected)
  }
}
