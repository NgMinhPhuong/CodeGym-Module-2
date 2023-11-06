import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTranslateTest {

    @org.junit.jupiter.api.Test
    void testTranSlate2() {
        String expected = "hai";
        String actual = FizzBuzzTranslate.tranSlate(2);
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testTranSlate1() {
        String expected = "ba ba";
        String actual = FizzBuzzTranslate.tranSlate(33);
        assertEquals(expected, actual);
    }
}