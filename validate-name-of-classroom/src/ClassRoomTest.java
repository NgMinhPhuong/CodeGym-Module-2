import static org.junit.jupiter.api.Assertions.*;

class ClassRoomTest {

    @org.junit.jupiter.api.Test
    void checkTrue() {
        boolean expected = true;
        boolean actual = ClassRoom.check("C0223G");
        boolean actual1 = ClassRoom.check("A0323K");
        assertEquals(expected, actual);
        assertEquals(expected, actual1);
    }
    @org.junit.jupiter.api.Test
    void checkFalse() {
        boolean expected = false;
        boolean actual = ClassRoom.check(" M0318G");
        boolean actual1 = ClassRoom.check("P0323A");
        assertEquals(expected, actual);
        assertEquals(expected, actual1);
    }
}