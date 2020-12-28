package ktpm.btcn06;

import ktpm.btcn06.Point;
import ktpm.btcn06.Triangle;
import ktpm.btcn06.TriangleType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {
  // =========================== TEST HAM TINH CHU VI ===================================
  @Test
  void testGetPerimeter1() { // tam giac hop le
    Point A = new Point(0, 0);
    Point B = new Point(3, 0);
    Point C = new Point(0, 4);

    Triangle triangle = new Triangle(A,B,C);

    assertEquals(3+4+5,triangle.getPerimeter());
  }

  @Test
  void testGetPerimeter2() { // khong phai tam giac hop le
    Point A = new Point(0, 0);
    Point B = new Point(3, 3);
    Point C = new Point(5, 5);

    Triangle triangle = new Triangle(A,B,C);

    assertEquals(0,triangle.getPerimeter());
  }

  // =========================== TEST TRUONG HOP CAC DIEM THANG HANG (KHONG PHAI TAM GIAC) ===================================
  @Test
  void testInvalidTriangle1() {
    Point A = new Point(0, 1);
    Point B = new Point(0, 2);
    Point C = new Point(0, 4);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.INVALID);
  }

  @Test
  void testInvalidTriangle2() {
    Point A = new Point(0, 0);
    Point B = new Point(1, 1);
    Point C = new Point(2, 2);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.INVALID);
  }

  @Test
  void testInvalidTriangle3() {
    Point A = new Point(0, 2);
    Point B = new Point(0, 4);
    Point C = new Point(0, 1);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.INVALID);
  }

  @Test
  void testInvalidTriangle4() {
    Point A = new Point(0, 0);
    Point B = new Point(0, 0);
    Point C = new Point(0, 0);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.INVALID);
  }

  // =========================== TEST TAM GIAC VUONG ===================================

  @Test
  void testRightAngledTriangle1() {
    Point A = new Point(0, 0);
    Point B = new Point(0, 3);
    Point C = new Point(4, 0);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.RIGHT_ANGLED);
  }

  @Test
  void testRightAngledTriangle2() {
    Point A = new Point(0, 0);
    Point B = new Point(3, 0);
    Point C = new Point(0, 4);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.RIGHT_ANGLED);
  }

  @Test
  void testRightAngledTriangle3() {
    Point A = new Point(3, 0);
    Point B = new Point(0, 0);
    Point C = new Point(0, 4);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.RIGHT_ANGLED);
  }

  // =========================== TEST TAM GIAC DEU ===================================

  @Test
  void testEquilateralTriangle1() { // cạnh bằng 12 (có làm tròn)
    Point A = new Point(12, 0);
    Point B = new Point(0, 0);
    Point C = new Point(6,10.392 );

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.EQUILATERAL);
  }

  @Test
  void testEquilateralTriangle2() { // cạnh bằng 100 (có làm tròn)
    Point A = new Point(100, 0);
    Point B = new Point(0, 0);
    Point C = new Point(50, 86.603);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.EQUILATERAL);
  }

  @Test
  void testEquilateralTriangle3() { // cạnh bằng 21.5
    Point A = new Point(21.5, 0);
    Point B = new Point(0, 0);
    Point C = new Point(10.75, 18.62);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.EQUILATERAL);
  }

  // =========================== TEST TAM GIAC CAN ===================================

  @Test
  void testIsoscelesTriangle1() { // các canh là 100,100,1
    Point A = new Point(100,0);
    Point B = new Point(0, 0);
    Point C = new Point(99.995,1 );

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.ISOSCELES);
  }

  @Test
  void testIsoscelesTriangle2() { // các cạnh là 12,12,5
    Point A = new Point(12, 0);
    Point B = new Point(0, 0);
    Point C = new Point(10.958, 4.89);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.ISOSCELES);
  }

  @Test
  void testIsoscelesTriangle3() { // các cạnh là 8,8, 7
    Point A = new Point(8, 0);
    Point B = new Point(0, 0);
    Point C = new Point(4.938, 6.295);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.ISOSCELES);
  }

  // =========================== TEST TAM GIAC THUONG ===================================

  @Test
  void testScaleneTriangle1() {
    Point A = new Point(123.3, 3);
    Point B = new Point(12, 4);
    Point C = new Point(5, 21);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.SCALENE);
  }

  @Test
  void testScaleneTriangle2() {
    Point A = new Point(21, 0);
    Point B = new Point(12, 0);
    Point C = new Point(0, 89);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.SCALENE);
  }

  @Test
  void testScaleneTriangle3() {
    Point B = new Point(12, 0);
    Point C = new Point(0, 89);
    Point A = new Point(21, 0);

    Triangle triangle = new Triangle(A, B, C);

    final TriangleType type = triangle.classify();

    assertEquals(type, TriangleType.SCALENE);
  }
}
