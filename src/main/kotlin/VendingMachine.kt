class VendingMachine {
  private val coins: ArrayList<CoinTypes> = arrayListOf()
  private val inventory: Map<Product, Int> =
      mapOf(Pair(Product.COLA, 1), Pair(Product.CHIPS, 1), Pair(Product.CANDY, 1))

  val balance: Int
    get() = coins.sumOf { it.getValueInCents() }


  val display: String
    get() = if (coins.isNotEmpty()) formatBalanceDisplay() else "INSERT COIN"

  var coinReturn: ArrayList<CoinTypes> = arrayListOf()

  fun acceptCoin(vararg coinsToInsert: CoinTypes) {
    for (coin in coinsToInsert) {
      if (isValidCoin(coin)) coins.add(coin) else returnInvalidCoin(coin)
    }
  }

   fun selectProduct(product: Product): Product? {
     return null
   }

  private fun formatBalanceDisplay(): String {
    val dollars = balance / 100
    val cents = balance % 100
    return "$$dollars.$cents"
  }

  private fun returnInvalidCoin(coin: CoinTypes) {
    coinReturn.add(coin)
  }

  private fun isValidCoin(coin: CoinTypes): Boolean {
    return coin.name != CoinTypes.PENNY.name
  }
}
