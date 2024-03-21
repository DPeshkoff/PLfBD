import org.junit.jupiter.api.Test
import org.lab9.People
import org.lab9.Sex
import kotlin.test.assertEquals

class PeopleTest {

    @Test
    fun testFindOldestMalePerson() {
        val peoples = listOf(
            People("Ivan", 16, Sex.MAN),
            People("Petr", 23, Sex.MAN),
            People("Maria", 42, Sex.WOMAN)
        )

        val oldestMale = peoples.stream()
            .filter { it.gender == Sex.MAN }
            .max(compareBy { it.age })
            .orElse(null)

        assertEquals(People("Petr", 23, Sex.MAN), oldestMale)
    }
}