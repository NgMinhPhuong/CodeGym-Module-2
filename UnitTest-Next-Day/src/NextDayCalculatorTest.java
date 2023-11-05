import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class NextDayCalculatorTest {

    @org.junit.jupiter.api.Test
    void testGetNextDay() {
        NextDayCalculator a = new NextDayCalculator(1, 1, 2018);
        String actual = a.getNextDay();
        String expected = "2/1/2018";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay1() {
        NextDayCalculator a = new NextDayCalculator(31, 1, 2018);
        String actual = a.getNextDay();
        String expected = "1/2/2018";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay2() {
        NextDayCalculator a = new NextDayCalculator(30, 4, 2018);
        String actual = a.getNextDay();
        String expected = "1/5/2018";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay3() {
        NextDayCalculator a = new NextDayCalculator(28, 2, 2018);
        String actual = a.getNextDay();
        String expected = "1/3/2018";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay4() {
        NextDayCalculator a = new NextDayCalculator(29, 2, 2020);
        String actual = a.getNextDay();
        String expected = "1/3/2020";
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetNextDay5() {
        NextDayCalculator a = new NextDayCalculator(31, 12, 2018);
        String actual = a.getNextDay();
        String expected = "1/1/2019";
        assertEquals(expected, actual);
    }


}