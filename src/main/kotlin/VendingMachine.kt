class VendingMachine {
  private val coins: ArrayList<CoinTypes> = arrayListOf()
  val balance: Int
    get() = coins.sumOf { it.getValueInCents() }

  val display: String
    get() = if (coins.isNotEmpty()) formatBalanceDisplay() else "INSERT COIN"

  var coinReturn: ArrayList<CoinTypes> = arrayListOf()

  fun acceptCoin(coin: CoinTypes) {
    addCoin(coin)
  }

  private fun formatBalanceDisplay(): String {
    val dollars = balance / 100
    val cents = balance % 100
    return "$$dollars.$cents"
  }

  private fun addCoin(coin: CoinTypes) {
    if (isValidCoin(coin)) coins.add(coin) else returnInvalidCoin(coin)
  }

  private fun returnInvalidCoin(coin: CoinTypes) {
    coinReturn.add(coin)
  }

  private fun isValidCoin(coin: CoinTypes): Boolean {
    return coin.name != CoinTypes.PENNY.name
  }
}
