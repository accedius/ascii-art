package io.exporter

import java.io.PrintWriter

import entity.image.TRasterImage

object FileExporter extends TExporter {
  def exportToFile(image: TRasterImage, path: String) = {
    val exporter = new PrintWriter(path)
    val imagePrint = prepareForExport(image)
    exporter.write(imagePrint)
    exporter.close()
  }
}
