class VendingMachine {
  private val coins: ArrayList<CoinTypes> = arrayListOf()
  val balance: Int
    get() = coins.sumOf { it.getValueInCents() }

  val display: String
    get() = if (coins.isNotEmpty()) formatBalanceDisplay() else ""

  fun acceptCoin(coin: CoinTypes) {
    addCoin(coin)
  }

  private fun formatBalanceDisplay(): String {
    return ""
  }

  private fun addCoin(coin: CoinTypes) {
    if (isValidCoin(coin)) coins.add(coin)
  }

  private fun isValidCoin(coin: CoinTypes): Boolean {
    return coin.name != CoinTypes.PENNY.name
  }
}
