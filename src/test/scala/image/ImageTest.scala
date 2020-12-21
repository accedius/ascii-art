package image

import org.scalatest.FunSuite

class ImageTest extends FunSuite with ImageFactory {
  test("Empty image") {
    assertThrows[IllegalArgumentException](makeImageAsciiFromArray(Array.empty))
    assertThrows[IllegalArgumentException](makeImageGrayscaleFromArray(Array.empty))
  }

  test("Row of zero length") {
    assertThrows[IllegalArgumentException](makeImageAsciiFromArray(Array(
      Array()
    )))
  }

  test("Rows of a different length") {
    assertThrows[IllegalArgumentException](makeImageGrayscaleFromArray(Array(
      Array(0, 1),
      Array(2))))
  }

  test("Grayscale image with invalid color values") {
    assertThrows[IllegalArgumentException](makeImageGrayscaleFromArray(Array(Array(-1))))
    assertThrows[IllegalArgumentException](makeImageGrayscaleFromArray(Array(Array(256))))
  }

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
