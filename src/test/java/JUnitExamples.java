import org.junit.jupiter.api.*;

public class JUnitExamples {

        @BeforeAll
        static void beforeAll() {
            System.out.println("Here is beforeAll()\n");
        }

        @BeforeEach
        void beforeEach() {
            System.out.println("    Here is beforeEach()");
        }

        @AfterAll
        static void afterAll() {
            System.out.println("\nHere is afterAll()\n");
        }

        @AfterEach
        void afterEach() {
            System.out.println("    Here is afterEach()");
        }

        @Test
        void firstTest() {
            System.out.println("        Here is firstTest()");
        }

        @Test
        void secondTest() {
            System.out.println("        Here is secondTest()");
        }
    }

