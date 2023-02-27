import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class VendingMachineTest {
  lateinit var subject: VendingMachine

  @BeforeEach
  fun setUp() {
    subject = VendingMachine()
  }

  @Test
  fun `coin value does not increases when penny is inserted`() {
    val expected = 0

    subject.acceptCoin(Coin.PENNY)

    assertEquals(expected, subject.balance)
  }

  @Test
  fun `coin value increases by 5 when nickle is inserted`() {
    val expected = 5

    subject.acceptCoin(Coin.NICKLE)

    assertEquals(expected, subject.balance)
  }

  @Test
  fun `coin value increases by 10 when dime is inserted`() {
    val expected = 10

    subject.acceptCoin(Coin.DIME)

    assertEquals(expected, subject.balance)
  }

  @Test
  fun `coin value increases by 25 when quarter is inserted`() {
    val expected = 25

    subject.acceptCoin(Coin.QUARTER)

    assertEquals(expected, subject.balance)
  }

  @Test
  fun `coin value increases to 50 cents when given 1 quarter, 2 dimes and 1 nickle`() {
    val expected = 50

    subject.acceptCoin(Coin.QUARTER, Coin.DIME, Coin.DIME, Coin.NICKLE)

    assertEquals(expected, subject.balance)
  }

  @Test
  fun `display value returns INSERT COIN when no coins have been inserted`() {
    val expected = "INSERT COIN"

    assertEquals(expected, subject.display)
  }

  @Test
  fun `display value returns $0,25 when a quarter is inserted`() {
    val expected = "$0.25"

    subject.acceptCoin(Coin.QUARTER)

    assertEquals(expected, subject.display)
  }

  @Test
  fun `display value returns $1,25 when a 5 quarters are inserted`() {
    val expected = "$1.25"

    subject.acceptCoin(
        Coin.QUARTER,
        Coin.QUARTER,
        Coin.QUARTER,
        Coin.QUARTER,
        Coin.QUARTER,
    )

    assertEquals(expected, subject.display)
  }

  @Test
  fun `when penny is inserted it is returned to the user via the coin return slot`() {
    val expected = listOf(Coin.PENNY)

    subject.acceptCoin(Coin.PENNY)

    assertEquals(expected, subject.coinReturn)
  }

  @Test
  fun `when a dime and two pennies are inserted the two pennies are returned to the user via the coin return slot`() {
    val expected = listOf(Coin.PENNY, Coin.PENNY)

    subject.acceptCoin(Coin.QUARTER, Coin.PENNY, Coin.PENNY)

    assertEquals(expected, subject.coinReturn)
  }

  @Test
  fun `when cola is selected with enough money inserted it is dispensed`() {
    subject.acceptCoin(Coin.QUARTER, Coin.QUARTER, Coin.QUARTER, Coin.QUARTER)
    val expected = Product.COLA

    val actual = subject.selectProduct(Product.COLA)

    assertEquals(expected, actual)
  }

  @Test
  fun `when chips is selected with enough money inserted it is dispensed`() {
    subject.acceptCoin(Coin.QUARTER, Coin.QUARTER)
    val expected = Product.CHIPS

    val actual = subject.selectProduct(Product.CHIPS)

    assertEquals(expected, actual)
  }

  @Test
  fun `when candy is selected with enough money inserted it is dispensed`() {
    subject.acceptCoin(Coin.QUARTER, Coin.QUARTER, Coin.DIME, Coin.NICKLE)
    val expected = Product.CANDY

    val actual = subject.selectProduct(Product.CANDY)

    assertEquals(expected, actual)
  }

  @Test
  fun `when cola is selected with insufficient money inserted no product is dispensed`() {
    val actual = subject.selectProduct(Product.COLA)

    assertNull(actual)
  }

  @Test
  fun `when product is vended balance is reset`() {
    subject.acceptCoin(Coin.QUARTER, Coin.QUARTER)
    val expected = 0

    subject.selectProduct(Product.CHIPS)

    assertEquals(expected, subject.balance)
  }

  @Test
  fun `when product is vended a thank you message is displayed`() {
    subject.acceptCoin(Coin.QUARTER, Coin.QUARTER)
    val expected = "THANK YOU"

    subject.selectProduct(Product.CHIPS)

    assertEquals(expected, subject.display)
  }

  @Test
  fun `when candy is selected with balance at 75 cents then 1 dime should be returned`() {
    subject.acceptCoin(Coin.QUARTER, Coin.QUARTER, Coin.QUARTER)
    val expected = listOf(Coin.DIME)

    subject.selectProduct(Product.CANDY)

    assertEquals(expected, subject.coinReturn)
  }

  @Test
  fun `when candy is selected with balance at 115 cents then 2 quarters should be returned`() {
    subject.acceptCoin(
        Coin.QUARTER,
        Coin.QUARTER,
        Coin.QUARTER,
        Coin.QUARTER,
        Coin.DIME,
        Coin.NICKLE)
    val expected = listOf(Coin.QUARTER, Coin.QUARTER)

    subject.selectProduct(Product.CANDY)

    assertEquals(expected, subject.coinReturn)
  }

  @Test
  fun `when chips are selected with balance at 90 cents then 1 quarter, 1 dime, and 1 nickle should be returned`() {
    subject.acceptCoin(
        Coin.QUARTER,
        Coin.NICKLE,
        Coin.DIME,
        Coin.DIME,
        Coin.DIME,
        Coin.DIME,
        Coin.DIME,
        Coin.DIME)
    val expected = listOf(Coin.QUARTER, Coin.DIME, Coin.NICKLE)

    subject.selectProduct(Product.CHIPS)

    assertEquals(expected, subject.coinReturn)
  }

  @Test
  fun `when return coins is pressed the coins entered by the customer are returned`() {
    subject.acceptCoin(
      Coin.QUARTER,
      Coin.DIME,
      Coin.NICKLE)
    val expected = listOf(Coin.QUARTER, Coin.DIME, Coin.NICKLE)


    subject.returnCoins()

    assertEquals(expected, subject.coinReturn)
  }

  @Test
  fun `when return coins is pressed the display should say insert coin`() {
    val expected = "INSERT COIN"

    subject.returnCoins()

    assertEquals(expected, subject.display)
  }
}
