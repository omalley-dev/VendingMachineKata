import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CoinTypesTest {

  @BeforeEach fun setUp() {}

  @Test
  fun `coins have appropriate values associated with them when used`() {
    val expectedMap = mapOf("PENNY" to 1, "NICKLE" to 5, "DIME" to 10, "QUARTER" to 25)

    for (coin in CoinTypes.values()) {
      val expectedCoinValue = expectedMap[coin.name]

      val actualCoinValue = coin.getValueInCents()

      assertEquals(expectedCoinValue, actualCoinValue)
    }
  }
}
