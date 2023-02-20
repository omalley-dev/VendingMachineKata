class VendingMachine {
  val coins: ArrayList<CoinTypes> = arrayListOf()
  val balance: Int
    get() = coins.sumOf { it.getValueInCents() }

  fun acceptCoin(coin: CoinTypes) {
    addCoin(coin)
  }

  private fun addCoin(coin: CoinTypes) {
    if (isValidCoin(coin)) coins.add(coin)
  }

  private fun isValidCoin(coin: CoinTypes): Boolean {
    return coin.name != CoinTypes.PENNY.name
  }
}
