package loader

import image.ImageFactory
import org.scalatest.FunSuite

class LoaderTest extends FunSuite with ImageFactory {
  test("Load an existing png image") {
    val expected = makeImageRgbFromArray(
      Array(
        Array((255, 0, 0), (255, 0, 0)),
        Array((255, 128, 128), (0, 128, 128))
      ))
    val loaded = makeImageFromFile("src/test/resources/pic.png")
    assert(expected == loaded)
  }
}
