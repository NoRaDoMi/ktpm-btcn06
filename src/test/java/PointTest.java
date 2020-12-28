import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testGetCorrectDistanceWithIntegerDistance() {
        Point A = new Point(0,0);
        Point B = new Point(3,4);

        double AB = A.getDistance(B);
        assertEquals(AB, 5);
    }

    @Test
    void testGetCorrectDistanceWithDoubleDistance() {
        Point A = new Point(0,0);
        Point B = new Point(2,2);

        double AB = A.getDistance(B);
        assertEquals(AB, Math.sqrt(2*2 + 2*2));
    }

    @Test
    void testGetCorrectDistanceWithBiDirectional() {
        Point A = new Point(0,0);
        Point B = new Point(2,2);

        double AB = A.getDistance(B);
        double BA = B.getDistance(A);
        assertEquals(AB, BA);
    }

    @Test
    void testInitPointWithOneNegativeParams() {
        Point A = new Point(-3,0);

        assertEquals(A.getA(), 0);
    }

    @Test
    void testInitPointWithBothNegativeParams() {
        Point X = new Point(-3,-3);

        Boolean res = X.getA() == 0 && X.getB() == 0;

        assertEquals(res,true );
    }
}