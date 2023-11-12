import static org.junit.jupiter.api.Assertions.*;

class EmailExampleTest {

    @org.junit.jupiter.api.Test
    void validateTrue() {
        boolean expected = true;
        EmailExample emailExample = new EmailExample();
        boolean actual1 = emailExample.validate("a@gmail.com");
        boolean actual2 = emailExample.validate("ab@yahoo.com");
        boolean actual3 = emailExample.validate("abc@hotmail.com");
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
    }

    @org.junit.jupiter.api.Test
    void validateFalse() {
        boolean expected = false;
        EmailExample emailExample = new EmailExample();
        boolean actual1 = emailExample.validate("@gmail.com");
        boolean actual2 = emailExample.validate("ab@gmail.");
        boolean actual3 = emailExample.validate("@#abc@gmail.com");
        assertEquals(expected, actual1);
        assertEquals(expected, actual2);
        assertEquals(expected, actual3);
    }
}