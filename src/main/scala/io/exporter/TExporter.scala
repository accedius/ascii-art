package io.exporter

import entity.image.TRasterImage

/**
 * Base trait for image exporters
 * Prepares image to be exported
 */
trait TExporter {
  protected def prepareForExport(entity: TRasterImage): String = entity.prepareForExport
}
