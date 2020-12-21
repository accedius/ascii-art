package image

import org.scalatest.FunSuite

class ImageTest extends FunSuite with ImageFactory {
  test("Image to Ascii valid conversion") {
    val rgb = makeImageFromFile("src/test/resources/sonic.png")
    val greyscale = rgb.toGrayscale
    val expectedGrayscale = makeImageGrayscaleFromArray(Array(
      Array(141, 141, 141, 141, 141, 141, 141, 141),
      Array(141, 78, 78, 78, 78, 78, 141, 141),
      Array(78, 78, 78, 0, 255, 0, 141, 141),
      Array(78, 141, 78, 197, 197, 197, 141, 141),
      Array(141, 78, 78, 78, 78, 78, 78, 141),
      Array(141, 78, 78, 197, 197, 78, 78, 141),
      Array(141, 255, 78, 197, 197, 78, 255, 141),
      Array(141, 141, 77, 141, 141, 77, 141, 141)
    ))
    assert(greyscale == expectedGrayscale)

    val ascii = greyscale.toAscii
    val expectedAscii = makeImageAsciiFromArray(Array(
      Array('=', '=', '=', '=', '=', '=', '=', '='),
      Array('=', '*', '*', '*', '*', '*', '=', '='),
      Array('*', '*', '*', '@', ' ', '@', '=', '='),
      Array('*', '=', '*', ':', ':', ':', '=', '='),
      Array('=', '*', '*', '*', '*', '*', '*', '='),
      Array('=', '*', '*', ':', ':', '*', '*', '='),
      Array('=', ' ', '*', ':', ':', '*', ' ', '='),
      Array('=', '=', '*', '=', '=', '*', '=', '=')
    ))
    assert(ascii == expectedAscii)
  }
}
