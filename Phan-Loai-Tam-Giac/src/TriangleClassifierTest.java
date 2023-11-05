import static org.junit.jupiter.api.Assertions.*;

class TriangleClassifierTest {

    @org.junit.jupiter.api.Test
    void testGetKindOfTriangle1() {
        TriangleClassifier a = new TriangleClassifier(2,2,2);
        String expected = "Tam giac deu";
        String actual = a.getKindOfTriangle();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetKindOfTriangle2() {
        TriangleClassifier a = new TriangleClassifier(2,2,3);
        String expected = "Tam giac can";
        String actual = a.getKindOfTriangle();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetKindOfTriangle3() {
        TriangleClassifier a = new TriangleClassifier(3,4,5);
        String expected = "Tam giac thuong";
        String actual = a.getKindOfTriangle();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetKindOfTriangle4() {
        TriangleClassifier a = new TriangleClassifier(8,2,3);
        String expected = "Khong phai la tam giac";
        String actual = a.getKindOfTriangle();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetKindOfTriangle5() {
        TriangleClassifier a = new TriangleClassifier(-1,2,1);
        String expected = "Khong phai la tam giac";
        String actual = a.getKindOfTriangle();
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void testGetKindOfTriangle6() {
        TriangleClassifier a = new TriangleClassifier(0,1,1);
        String expected = "Khong phai la tam giac";
        String actual = a.getKindOfTriangle();
        assertEquals(expected, actual);
    }
}