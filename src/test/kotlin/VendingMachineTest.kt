import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class VendingMachineTest {

  lateinit var subject: VendingMachine

  @BeforeEach
  fun setUp() {
    subject = VendingMachine()
  }

  @Test
  fun `coin value increases by 1 when penny is inserted`() {
    val expected = 1

    subject.acceptCoin(CoinTypes.PENNY)

    assertEquals(expected, subject.coinValue)
  }

  @Test
  fun `coin value increases by 5 when nickle is inserted`() {
    val expected = 5

    subject.acceptCoin(CoinTypes.NICKLE)

    assertEquals(expected, subject.coinValue)
  }

  @Test
  fun `coin value increases by 10 when dime is inserted`() {
    val expected = 10

    subject.acceptCoin(CoinTypes.DIME)

    assertEquals(expected, subject.coinValue)
  }

  @Test
  fun `coin value increases by 25 when quarter is inserted`() {
    val expected = 25

    subject.acceptCoin(CoinTypes.QUARTER)

    assertEquals(expected, subject.coinValue)
  }
}