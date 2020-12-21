package io.loader
import java.awt.image.BufferedImage
import java.io.File

import entity.image.ImageRgb
import javax.imageio.ImageReader
import javax.imageio.ImageIO

import javax.imageio.stream.ImageInputStream

object FileLoader extends TImageLoader {
  /**
   * Loads the image using given parameters
   * @param loadParameters - parameters, describing the way of obtaining the image (i.e. path or url)
   * @return - rgb image loaded as ImageRgb object
   */
  override def load(loadParameters: String*): ImageRgb = {
    if(loadParameters.size != 1) {
      throw new IllegalArgumentException("Invalid argument count: only path to the image needed!")
    }
    val pathToImage = loadParameters(0)

    val imageFile: File = new File(pathToImage);
    if(!imageFile.canRead) {
      throw new RuntimeException("Can't read the image file located at: \"" + imageFile.getAbsolutePath + "\"")
    }

    val imageStream: ImageInputStream = ImageIO.createImageInputStream(imageFile)
    val readers = ImageIO.getImageReaders(imageStream)

    if(readers.hasNext) {
      val imageReader: ImageReader = readers.next
      imageReader.setInput(imageStream)

      val imageFormat: String = imageReader.getFormatName
      if(!supportedImageFormats.contains(imageFormat)) {
        throw new IllegalArgumentException("Image format \"" + imageFormat + "\" not supported.\nSupported formats: " + supportedImageFormats.mkString(", "))
      }

      val image: BufferedImage = imageReader.read(0)
      convertToImageRgb(image)
    } else {
      throw new RuntimeException("Can't read the image file located at: \"" + imageFile.getAbsolutePath + "\"")
    }
  }

  val supportedImageFormats: Seq[String] = Seq("png", "jpg", "jpeg")
}
