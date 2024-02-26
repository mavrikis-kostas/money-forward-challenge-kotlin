import com.moneyforward.challenge.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AssignmentsKtTest {

    @Test
    fun `getName should return the user's name`() {
        val user = User(
            id = 1,
            name = "John Doe",
            accountIds = listOf(1, 2, 3)
        )
        val userResponse = UserResponse(user)

        val actualName = userResponse.getName()
        val expectedName = "John Doe"

        assertEquals(expectedName, actualName)
    }
}