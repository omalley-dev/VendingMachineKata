
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @BeforeEach
    fun setUp() {
    }

    @Test
    fun `when main is executed it returns Unit type`() {
        val returned = main()

        assertEquals(Unit.javaClass.simpleName, returned.javaClass.simpleName)
    }
}