enum class Product : IProduct {
  COLA {
    override fun getValueInCents() = 100
  },
  CHIPS {
    override fun getValueInCents() = 50
  },
  CANDY {
    override fun getValueInCents() = 65
  }
}
