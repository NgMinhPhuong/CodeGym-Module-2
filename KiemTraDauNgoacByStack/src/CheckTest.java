import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckTest {

    @Test
    void checkDauNgoac1() {
        String expected = "Hop le";
        Check a = new Check();
        String actual = a.checkDauNgoac("s * (s – a) * (s – b) * (s – c)");
        assertEquals(expected, actual);
    }

    @Test
    void checkDauNgoac2() {
        String expected = "Hop le";
        Check a = new Check();
        String actual = a.checkDauNgoac("(– b + (b2 – 4*a*c)^0.5) / 2*a");
        assertEquals(expected, actual);
    }

    @Test
    void checkDauNgoac3() {
        String expected = "Khong hop le";
        Check a = new Check();
        String actual = a.checkDauNgoac("s * (s – a) * (s – b * (s – c)");
        assertEquals(expected, actual);
    }

    @Test
    void checkDauNgoac4() {
        String expected = "Khong hop le";
        Check a = new Check();
        String actual = a.checkDauNgoac("s * (s – a) * s – b) * (s – c)");
        assertEquals(expected, actual);
    }

    @Test
    void checkDauNgoac5() {
        String expected = "Hop le";
        Check a = new Check();
        String actual = a.checkDauNgoac("(– b + (b^2 – 4*a*c)^(0.5/ 2*a))");
        assertEquals(expected, actual);
    }

}