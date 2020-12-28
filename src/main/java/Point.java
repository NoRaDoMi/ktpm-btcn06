public class Point {
    private double a;
    private double b;

    public Point() {
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public Point(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getDistance(Point x){
        return Math.round(Math.sqrt(Math.pow(x.a - this.a,2) + Math.pow(x.b - this.b,2))*1000)/1000;
    }
}