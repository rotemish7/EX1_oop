
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import Ex1.Polynom;
import Ex1.Range;
import Ex1.StdDraw;
import Ex1.function;
public class testSTD
{

	public static void main(String[] args) 
	{
		ArrayList<function> funcs = new ArrayList<function>();
		function f = new Polynom("3x");
		funcs.add(f);
		Range rx = new Range(-10,10);
		Range ry = new Range(-15,15);
		int resolution = 200;
		double[] x = new double[resolution+1];
		double[] y = new double[resolution+1];
		double rangeX = Math.abs(rx.get_max())+Math.abs(rx.get_min());
		double rangeY =Math.abs(ry.get_max())+Math.abs(ry.get_min());
		System.out.println(rangeX);
		System.out.println(rangeY);
		for (int i = 0; i < resolution; i++) 
		{
			x[i] = rx.get_min()+rangeX * i / resolution;
			y[i] = funcs.get(0).f(x[i]);
		}
		//		// number of line segments to plot
		//		int n = 30;
		//		double maxY = 10.0, minY = -10.0;
		//		// the function y = sin(4x), sampled at n+1 points
		//		// between x = 0 and x = pi
		//		double[] x = new double[n+1];
		//		double[] y = new double[n+1];
		//		for (int i = 0; i <= n; i++) {
		//			x[i] = Math.PI * i / n;
		//			System.out.print(x[i] + ",");
		//			y[i] = Math.sin(4*x[i]);
		//			System.out.print(y[i]);
		//			System.out.println();
		//		}
		StdDraw.setCanvasSize(1000,1000);
		// rescale the coordinate system
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		//////// vertical lines
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = (int)rx.get_min(); i < rx.get_max(); i++)
		{
			StdDraw.line(i, ry.get_min(), i, ry.get_max());
		}
		//////// horizontal lines
		for (double i = ry.get_min(); i < ry.get_max(); i++)
		{
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}
		//////// x axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		for (int i = (int)rx.get_min(); i < rx.get_max()+1; i++) 
		{
			//StdDraw.text(i, -0.20, Integer.toString(i));
		}

		////////y axis
		StdDraw.line(0,ry.get_min(),0,ry.get_max());
		for (double i = ry.get_min(); i < ry.get_max(); i++)
		{
			//StdDraw.text(x[resolution/2]-0.07, i+0.07, Double.toString(i));
		}

		StdDraw.setPenColor(Color.ORANGE);
		// plot the approximation to the function
		for (int i = 0; i < resolution; i++) 
		{
			StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
		}
		StdDraw.setPenColor(Color.RED);
		StdDraw.setPenRadius(0.01);
		StdDraw.point(x[resolution/2], 1);
	}
}
