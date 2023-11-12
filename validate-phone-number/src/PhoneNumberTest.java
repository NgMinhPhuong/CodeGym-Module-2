import static org.junit.jupiter.api.Assertions.*;

class PhoneNumberTest {

    @org.junit.jupiter.api.Test
    void checkTrue() {
        boolean expected = true;
        boolean actual = PhoneNumber.check("(84)-(0978489648)");
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void checkFalse() {
        boolean expected = false;
        boolean actual = PhoneNumber.check("(a8)-(22222222)");
        boolean actual1 = PhoneNumber.check("(84)-(22b22222)");
        boolean actual2 = PhoneNumber.check("(84)-(9978489648)");
        assertEquals(expected, actual);
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
    }
}