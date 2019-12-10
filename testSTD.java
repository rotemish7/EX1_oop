
import java.awt.Color;
import java.awt.Font;

import Ex1.StdDraw;
public class testSTD {

	public static void main(String[] args) 
	{
		// number of line segments to plot
		int n = 20;
		double maxY = 10.0, minY = -10.0;
		// the function y = sin(4x), sampled at n+1 points
		// between x = 0 and x = pi
		double[] x = new double[n+1];
		double[] y = new double[n+1];
		for (int i = 0; i <= n; i++) {
			x[i] = Math.PI * i / n;
			y[i] = Math.sin(4*x[i]);
		}
		// rescale the coordinate system
		StdDraw.setXscale(0, Math.PI);
		StdDraw.setYscale(-10, Math.PI);
		//////// vertical lines
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = 0; i <= n; i++) {
			StdDraw.line(x[i], minY, x[i], maxY);
		}
		//////// horizontal lines
		for (double i = minY; i <= maxY; i++) {
			StdDraw.line(0, i, Math.PI, i);
		}
		//////// x axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(0, y[n/2], Math.PI, y[n/2]);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		for (int i = 0; i <= n; i++) {
			StdDraw.text(x[i]-0.07, -0.07, Integer.toString(i-n/2));
		}
		//////// y axis
		StdDraw.line(x[n/2], minY, x[n/2], maxY);
		for (double i = minY; i <= maxY; i++) {
			StdDraw.text(x[n/2]-0.07, i+0.07, Double.toString(i));
		}
		// plot the approximation to the function
		for (int i = 0; i < n; i++) {
			StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
		}
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.01);
		StdDraw.point(x[n/2], 1);
	}
}
