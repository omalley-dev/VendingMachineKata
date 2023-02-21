enum class Product : IProduct {
  COLA {
    override fun getValueInCents() = 0
  },
  CHIPS {
    override fun getValueInCents() = 0
  },
  CANDY {
    override fun getValueInCents() = 0
  }
}
