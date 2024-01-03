import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @BeforeAll
    static void setUpAll(){
        System.out.println("BeforeAll is executed\n");
    }

    @AfterAll
    static void teardownAll(){
        System.out.println("AfterAll is executed");
    }

    @BeforeEach
    void setUpEach(){
        System.out.println("   BeforeEach is executed");
    }

    @AfterEach
    void tearDown(){
        System.out.println("   AfterEach is executed\n");
    }


    @Test
    void testCase1() {
        System.out.println("      Test case 1");
        //fail("Not implemented yet");
    }

    @Test
    void testCase2() {
        System.out.println("      Test case 2");
//       assertTrue(Calculator.operator.equals("add"));
        assertEquals("add", Calculator.operator);
    }

    @Test
    void testCase3() {
        System.out.println("      Test case 3");
        //assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});
    }

    @Test
    void testCase4() {
        System.out.println("    Test case 4");
        String nullString = null;
        String notNullString = "Cydeo";

//        assertNull(nullString);
//        assertNotNull(notNullString);
        //assertNotNull(nullString);
    }

    @Test
    void testCase5() {
        System.out.println("      Test case 5");
        Calculator c1 = new Calculator();
        Calculator c2 = c1;
        Calculator c3 = new Calculator();

        // checking if 2 objects have the same reference
        assertSame(c1, c2);
        assertNotSame(c1, c3);
    }


    @Test
    void add() {

        System.out.println("      Test case - add()");

        int actual = Calculator.add(2, 3);

        //assertEquals(6, actual, "It is not matching with expected value");
    }

    @Test
    void divide() {
        System.out.println("      Test case divide");
        // can not divide by zero
        //           expected exception              actual exception
        assertThrows(ArithmeticException.class, () -> Calculator.divide(0, 10));
    }


}