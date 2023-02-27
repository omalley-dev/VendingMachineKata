import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ProductTest {
  @Test
  fun `coins have appropriate values associated with them when used`() {
    val expectedMap = mapOf("COLA" to 100, "CHIPS" to 50, "CANDY" to 65)

    for (product in Product.values()) {
      val expected = expectedMap[product.name]

      val actual = product.getValueInCents()

      assertEquals(expected, actual)
    }
  }
}