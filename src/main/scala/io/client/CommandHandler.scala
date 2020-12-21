package io.client

import entity.image.{ImageRgb, TRasterImage}
import io.client.command.CommandSeq
import io.client.parser.CommandParser.availableCommands
import io.exporter.{ConsoleExporter, FileExporter}
import io.loader.FileLoader

/**
 * Handles command evaluation
 * @param commandSeq - Sequence of commands to execute
 */
case class CommandHandler(private val commandSeq: CommandSeq) {
  private val imageOriginal = loadImage
  private val imageGrayscale = imageOriginal.toGrayscale
  private val imageAscii = imageGrayscale.toAscii

  /**
   * Runs evaluation for given command sequence
   */
  def run: Unit = {
    commandSeq.commands.foreach { command =>
      command.name match {
        case "output-file" =>
          val pathToSaveTo = command.getParameter
          FileExporter.exportToFile(imageAscii, pathToSaveTo)
        case "output-console" =>
          ConsoleExporter.exportToConsole(imageAscii)
        case "image" =>
        case _ => throw new IllegalArgumentException("Command \"" + command + "\" is not valid. Available commands: " + availableCommands.mkString(", "))
      }
    }
  }

  private def loadImage: ImageRgb = {
    val loadCommand = commandSeq.find(command => command.name == "image").getOrElse(throw new IllegalArgumentException("No image for conversion defined!"))
    val pathToImage = loadCommand.getParameter

    FileLoader.load(pathToImage)
  }
}
