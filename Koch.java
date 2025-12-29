/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

    public static void main(String[] args) {

        
        // Tests the curve function:
        //curve(4, 0.1, 0.5, 0.9, 0.5);
        //StdDraw.show();
        

        
        // Tests the snowflake function:
        snowFlake(6);
        StdDraw.show();
        
    }

/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
    public static void curve(int n, double x1, double y1, double x2, double y2) {
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        // Divide into thirds: A and B
        double ax = (2 * x1 + x2) / 3.0;
        double ay = (2 * y1 + y2) / 3.0;

        double bx = (x1 + 2 * x2) / 3.0;
        double by = (y1 + 2 * y2) / 3.0;

        // Correct "outside" vertex for the equilateral triangle on segment A->B
        // (fixed orientation vs. the inward-bump version)
        double cx = (Math.sqrt(3) / 2.0) * (by - ay) + (ax + bx) / 2.0;
        double cy = (Math.sqrt(3) / 2.0) * (ax - bx) + (ay + by) / 2.0;

        // Recurse on the 4 resulting segments
        curve(n - 1, x1, y1, ax, ay);
        curve(n - 1, ax, ay, cx, cy);
        curve(n - 1, cx, cy, bx, by);
        curve(n - 1, bx, by, x2, y2);
    }

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
    public static void snowFlake(int n) {
        // A little tweak that makes the drawing look better
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);

        // Base equilateral triangle (fits nicely in the canvas)
        double x1 = 0.10, y1 = 0.10;
        double x2 = 1.00, y2 = 0.10;
        double side = x2 - x1;
        double x3 = (x1 + x2) / 2.0;
        double y3 = y1 + (Math.sqrt(3) / 2.0) * side;

        // Draw 3 Koch curves around the triangle
        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}