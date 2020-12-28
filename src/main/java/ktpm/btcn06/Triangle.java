package ktpm.btcn06;

public class Triangle {
  private Point A;
  private Point B;
  private Point C;

  public Triangle() {}

  public Triangle(Point a, Point b, Point c) {
    A = a;
    B = b;
    C = c;
  }

  //    Tính chu vi
  public double getPerimeter() {
    double AB = A.getDistance(B);
    double AC = A.getDistance(C);
    double BC = B.getDistance(C);

    if (AB < AC + BC && AC < AB + BC && BC < AB + AC) {
      return A.getDistance(B) + A.getDistance(C) + B.getDistance(C);
    }
    else return 0;
  }

  //    Phân loại tam giác
  public TriangleType classify() {
    double AB = A.getDistance(B);
    double AC = A.getDistance(C);
    double BC = B.getDistance(C);

    if (AB < AC + BC && AC < AB + BC && BC < AB + AC) { // là tam giác hợp lệ
      if ((AB * AB == AC * AC + BC * BC)
          || (AC * AC == BC * BC + AB * AB)
          || (BC * BC == AB * AB + AC * AC)) return TriangleType.RIGHT_ANGLED; // tam giác vuông
      else if (AB == AC && AC == BC) return TriangleType.EQUILATERAL; // tam giác đều
      else if (AB == AC || AB == BC || AC == BC) return TriangleType.ISOSCELES; // tam giác cân
      else return TriangleType.SCALENE;
    } else return TriangleType.INVALID; // không phải tam giác hợp lệ
  }
}
