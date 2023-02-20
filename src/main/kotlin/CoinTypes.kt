interface ICoin {
  fun getValueInCents(): Int
}

enum class CoinTypes : ICoin {
  COIN1 {
    override fun getValueInCents(): Int {
      TODO("Not yet implemented")
    }
  },
  COIN2 {
    override fun getValueInCents(): Int {
      TODO("Not yet implemented")
    }
  },
  COIN3 {
    override fun getValueInCents(): Int {
      TODO("Not yet implemented")
    }
  },
  COIN4 {
    override fun getValueInCents(): Int {
      TODO("Not yet implemented")
    }
  }
}
