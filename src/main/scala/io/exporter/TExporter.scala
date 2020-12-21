package io.exporter

import entity.image.TRasterImage

trait TExporter {
  protected def prepareForExport(entity: TRasterImage): String = entity.prepareForExport
}
