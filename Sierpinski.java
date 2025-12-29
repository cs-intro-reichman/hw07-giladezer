/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		// draw an equal triangle with a length of 0.5 that starts at (0.2, 0.2)
		sierpinski(10);
	}

	public static void drawTriangle(double x1, double x2, double x3,
		                             double y1, double y2, double y3) {
		StdDraw.polygon(new double[]{x1, x2, x3}, new double[]{y1, y2, y3});
	}

	public static void drawFlippedTriangle(
        double x1, double x2, double x3,
        double y1, double y2, double y3) {

    double yCenter = (y1 + y2 + y3) / 3;

    double fy1 = 2 * yCenter - y1;
    double fy2 = 2 * yCenter - y2;
    double fy3 = 2 * yCenter - y3;

    StdDraw.polygon(
        new double[]{x1, x2, x3},
        new double[]{fy1, fy2, fy3}
    );
}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {

		sierpinski(n, 0.0, 1.0, 0.5,
		               0.0, 0.0, Math.sqrt(3) / 2);
		
	}
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
		if (n == 0) {
			drawTriangle(x1, x2, x3, y1, y2, y3);
		} else {
			double x12 = (x1 + x2) / 2;
			double x23 = (x2 + x3) / 2;
			double x31 = (x3 + x1) / 2;

			double y12 = (y1 + y2) / 2;
			double y23 = (y2 + y3) / 2;
			double y31 = (y3 + y1) / 2;

			sierpinski(n - 1, x1, x12, x31, y1, y12, y31);
			sierpinski(n - 1, x2, x23, x12, y2, y23, y12);
			sierpinski(n - 1, x3, x31, x23, y3, y31, y23);
		}
	}
}
