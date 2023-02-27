class VendingMachine {
  private var coins: ArrayList<Coin> = arrayListOf()
  private val inventory: Map<Product, Int> =
      mapOf(Pair(Product.COLA, 1), Pair(Product.CHIPS, 1), Pair(Product.CANDY, 1))
  private var justVended = false

  val balance: Int
    get() = coins.sumOf { it.getValueInCents() }

  var display: String = ""
    get() = getDisplayMessage()
    set(text) {
      field = text
    }

  var coinReturn: ArrayList<Coin> = arrayListOf()

  fun acceptCoin(vararg coinsToInsert: Coin) {
    for (coin in coinsToInsert) {
      if (isValidCoin(coin)) coins.add(coin) else returnInvalidCoin(coin)
    }
  }

  fun selectProduct(product: Product): Product? {
    return if (canAffordProduct(product)) vend(product) else null
  }

  fun returnCoins() {
    coinReturn.addAll(coins)
    coins = arrayListOf()
  }

  private fun getDisplayMessage(): String {
    return if (coins.isNotEmpty()) {
      formatBalanceDisplay()
    } else if (justVended) {
      justVended = false
      "THANK YOU"
    } else {
      "INSERT COIN"
    }
  }

  private fun vend(product: Product): Product {
    makeChange(product)
    coins = arrayListOf()
    justVended = true
    return product
  }

  private fun makeChange(product: Product) {
    var delta = balance - product.getValueInCents()

    while (delta > 0) {
      val coin = getLargestPossibleCoin(delta)
      coinReturn.add(coin)
      delta -= coin.getValueInCents()
    }
  }

  private fun getLargestPossibleCoin(delta: Int): Coin {
    val coin: Coin =
        when (true) {
          (delta >= 25) -> Coin.QUARTER
          (delta >= 10) -> Coin.DIME
          (delta >= 5) -> Coin.NICKLE
          else -> Coin.PENNY
        }
    return coin
  }

  private fun canAffordProduct(product: Product): Boolean {
    return balance >= product.getValueInCents()
  }

  private fun formatBalanceDisplay(): String {
    val dollars = balance / 100
    val cents = balance % 100
    return "$$dollars.$cents"
  }

  private fun returnInvalidCoin(coin: Coin) {
    coinReturn.add(coin)
  }

  private fun isValidCoin(coin: Coin): Boolean {
    return coin.name != Coin.PENNY.name
  }
}
