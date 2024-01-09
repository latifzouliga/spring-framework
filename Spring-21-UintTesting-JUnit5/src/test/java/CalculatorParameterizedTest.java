import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

public class CalculatorParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Python", "Javascript"})
    void testCase1(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 6, 9, 21, 13})
    void testCase2(int number) {
        Assertions.assertEquals(0, number % 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Java", "Python", "Javascript"})
//    @EmptySource
//    @NullSource
    @NullAndEmptySource
    void testCase3(String args) {
        Assertions.assertTrue(!args.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void testCase4(String args) {
        Assertions.assertNotNull(args);
    }

    static String[] stringProvider() {
        return new String[]{"Java", "Python", "Javascript"};
    }

    @Tag("test2")
    @ParameterizedTest
    @CsvSource({
            "10,20,30",
            "20,30,50",
            "30,20,100"
    })
    void testCase5(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    @Tag("test6")
    @ParameterizedTest
    @CsvFileSource(resources = "/sampleData.csv", numLinesToSkip = 1)
    void testCase6(int num1, int num2, int result) {
        Assertions.assertEquals(result, Calculator.add(num1, num2));
    }

    // mvn -Dtest=Test=TestCircle#test test
    // maven-surefire-plugin
    // mvn clean test

}
