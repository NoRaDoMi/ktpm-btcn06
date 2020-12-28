package ktpm.btcn06;

import ktpm.btcn06.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

  @Test
  void testGetCorrectDistanceWithIntegerDistance() {
    Point A = new Point(0, 0);
    Point B = new Point(3, 4);

    double AB = A.getDistance(B);
    assertEquals(AB, 5);
  }

  @Test
  void testGetCorrectDistanceWithDoubleDistance() {
    Point A = new Point(0, 0);
    Point B = new Point(2, 2);

    double AB = A.getDistance(B);
    assertEquals(AB, Math.round(Math.sqrt(2 * 2 + 2 * 2)*1000)/1000);
  }

  @Test
  void testGetCorrectDistanceWithBiDirectional() {
    Point A = new Point(0, 0);
    Point B = new Point(2, 2);

    double AB = A.getDistance(B);
    double BA = B.getDistance(A);
    assertEquals(AB, BA);
  }

}
