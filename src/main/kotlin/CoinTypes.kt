enum class CoinTypes : ICoin {
  PENNY {
    override fun getValueInCents() = 1
  },
  NICKLE {
    override fun getValueInCents() = 5
  },
  DIME {
    override fun getValueInCents() = 10
  },
  QUARTER {
    override fun getValueInCents() = 25
  }
}
