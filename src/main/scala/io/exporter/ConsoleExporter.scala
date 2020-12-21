package io.exporter

import entity.image.TRasterImage

object ConsoleExporter extends TExporter {
  def exportToConsole(image: TRasterImage): Unit = {
    val imagePrint = prepareForExport(image)
    print(imagePrint)
  }
}
