import org.junit.jupiter.api.Test
import org.lab5.replacePublicWithPrivate
import java.io.File
import kotlin.test.assertEquals

class ModifyJavaProgramTest {

    private val testJavaProgram = """
        public class TestClass {
            public String publicField;
            
            public void publicMethod() {
                publicField = "public data";
            }
        }
    """.trimIndent()

    @Test
    fun testReplacePublicWithPrivate() {
        val testFile = File("src/test/resources/test_java_program.java")
        testFile.writeText(testJavaProgram)

        val inputFilePath = testFile.absolutePath
        val outputDirectory = "src/test/resources/output"

        replacePublicWithPrivate(inputFilePath, outputDirectory)

        val outputFile = File("$outputDirectory/modified_java_program.java")
        val modifiedLines = outputFile.readLines()

        val expectedModifiedLines = """
            private class TestClass {
                private String publicField;
                
                private void publicMethod() {
                    publicField = "private data";
                }
            }
        """.trimIndent()

        assertEquals(expectedModifiedLines.split('\n'), modifiedLines)

        // Clean up
        testFile.delete()
        outputFile.delete()
        File(outputDirectory).delete()
    }
}