class VendingMachine {
  var coinValue: Int = 0

  fun acceptCoin(coin: CoinTypes) {
    coinValue += coin.getValueInCents()
  }
}
