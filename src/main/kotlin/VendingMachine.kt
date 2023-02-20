class VendingMachine {
  private val coins: ArrayList<CoinTypes> = arrayListOf()
  val balance: Int
    get() = coins.sumOf { it.getValueInCents() }

  val display: String
    get() = if (coins.isNotEmpty()) formatBalanceDisplay() else "INSERT COIN"

  val coinReturn: List<CoinTypes>
    get() = listOf()

  fun acceptCoin(coin: CoinTypes) {
    addCoin(coin)
  }

  private fun formatBalanceDisplay(): String {
    val dollars = balance / 100
    val cents = balance % 100
    return "$$dollars.$cents"
  }

  private fun addCoin(coin: CoinTypes) {
    if (isValidCoin(coin)) coins.add(coin)
  }

  private fun isValidCoin(coin: CoinTypes): Boolean {
    return coin.name != CoinTypes.PENNY.name
  }
}
