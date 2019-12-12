package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.google.gson.Gson;

public class Functions_GUI implements functions 
{
	ArrayList<function> funcs;
	
	public Functions_GUI()
	{
		funcs = new ArrayList<function>();
	}

	//static array for the functions colors
	public static Color[] Colors = {Color.blue, Color.cyan,Color.MAGENTA, Color.ORANGE, Color.red, Color.GREEN, Color.PINK};
	
	@Override
	public boolean add(function e) 
	{
		if(funcs.add(e))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends function> c) 
	{
		if(funcs.addAll(c))
		{
			return true;
		}
		return false;
<<<<<<< HEAD
=======

>>>>>>> 13d47ae52bf91db299f8d797fed97115b661c75b
	}

	@Override
	public void clear() 
	{
		funcs.clear();
	}

	@Override
	public boolean contains(Object o) 
	{
		if(funcs.contains(o))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) 
	{
		if (funcs.containsAll(c))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isEmpty() 
	{
		if(funcs.isEmpty())
		{
			return true;
		}
		return false;
	}

	@Override
	public Iterator<function> iterator() 
	{
		return funcs.iterator();
	}

	@Override
	public boolean remove(Object o) 
	{
		if(funcs.remove(o))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) 
	{
		funcs.removeAll(c);

		if (funcs.isEmpty())
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) 
	{
		if (funcs.retainAll(c))
		{
			return true;
		}
		return false;
	}

	@Override
	public int size() 
	{
		return funcs.size();
	}

	@Override
	public Object[] toArray() 
	{
		return funcs.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) 
	{
		return funcs.toArray(a);
	}

	@Override
	/**
	 * initialize from a file
	 */
	public void initFromFile(String file) throws IOException 
	{
		String line = "";

		try 
		{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			int i = 0;
			
			while ((line = br.readLine()) != null) 
			{
				this.funcs.get(i++).initFromString(line);
				line = br.readLine();
			}
			br.close();
			fr.close();
			
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("could not read file");
		}
	}

	@Override
	/**
	 * saving to a file
	 */
	public void saveToFile(String file) throws IOException 
	{
		
		try 
		{
<<<<<<< HEAD
			FileWriter fw = new FileWriter(file);
			PrintWriter pw = new PrintWriter(new File(file));
			//StringBuilder sb = new StringBuilder();
=======
			PrintWriter pw = new PrintWriter(new File(fileName));
			StringBuilder sb = new StringBuilder();
>>>>>>> 13d47ae52bf91db299f8d797fed97115b661c75b

			for(int i=0; i<funcs.size(); i++)
			{
				pw.println(funcs.get(i).toString());
				pw.close();
				fw.close();
//				sb.append(funcs.get(i).toString());
//				sb.append("\n");
			}
//			pw.write(sb.toString());
//			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}

	@Override
	/**
	 * function that draws the functions in the arraylist
	 */
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution)
	{
<<<<<<< HEAD
		double[] x = new double[resolution+1];
		double[] y = new double[resolution+1];
		double rangeX = rx.get_max()-rx.get_min();
		double rangeY = ry.get_max()-ry.get_min();

		//Set the canvas size
=======
//		double ranX = rx.get_max()-rx.get_min();
//		double []x = new double [(int) ranX+1];
//		double []y = new double [(int) ranX+1];
//			for (int i= (int)rx.get_min(); i<rx.get_max(); i++)
//			{
//				x[i] = i;
//			}
//			for (int i = 0; i < y.length; i++)
//			{
//				y[i] = funcs.get(i).f(i);
//			}
			double[] x = new double[resolution+1];
			double[] y = new double[resolution+1];
			double rangeX = rx.get_max()-rx.get_min();
			double rangeY = ry.get_max()-ry.get_min();
			
			for (int i = 0; i <= x.length; i++) 
			{
			x[i] = rx.get_max()+rangeX * i / resolution;
			y[i] = funcs.get(i).f(x[i]);
			}
			// 

>>>>>>> 13d47ae52bf91db299f8d797fed97115b661c75b
		StdDraw.setCanvasSize(width, height);
		// rescale the coordinate system
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
<<<<<<< HEAD
		//Drawing vertical lines
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = (int)rx.get_min(); i <= rx.get_max(); i++)
		{
			StdDraw.line(i, ry.get_min(), i, ry.get_max());
		}
		//Drawing horizontal lines
		for (double i = ry.get_min(); i < ry.get_max(); i++)
		{
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}
		//Drawing the x axis and numbers
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		
		for (int i = (int)rx.get_min(); i < rx.get_max()+1; i++) 
		{
			StdDraw.text(i-0.07, -0.3, Integer.toString(i));
		}

		//Drawing the y axis and numbers
		StdDraw.line(0,ry.get_min(),0,ry.get_max());
		for (int i = (int)ry.get_min(); i < ry.get_max(); i++)
		{
			StdDraw.text(x[resolution/2]-0.2, i-0.07, Integer.toString(i));
		}

		for(int i= 0; i<funcs.size();i++)
		{
			// sampled at resolution points in the y value of the function in the array  for rx range
			for (int j = 0; j <= resolution; j++) 
			{
				  x[j] = rx.get_min()+j*rangeX/resolution;
				  y[j] = this.funcs.get(i).f(x[j]);
			}
			//set the pen Color and size for the functions
			StdDraw.setPenColor(Colors[i%6]);
			StdDraw.setPenRadius(0.005);
		
			// plot the approximation to the function
			for (int j = 0; j < resolution; j++)
			{
				StdDraw.line(x[j], y[j], x[j+1], y[j+1]);				
			}
			//printing the function number in the arraylist + color + the function itself
			System.out.println(i+")"+Colors[i%6]+"    f(x)="+this.funcs.get(i).toString());
=======
		//vertical lines
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = 0; i <= rangeX; i++) 
		{
			StdDraw.line(i, ry.get_min(), x[i], ry.get_max());
		}
		//horizontal lines
		for (double i = ry.get_min(); i <= ry.get_max(); i++) 
		{
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}
		//x axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(), (ry.get_max()-ry.get_min())/2, rx.get_max(), (ry.get_max()-ry.get_min())/2);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		
		for (int i = (int) rx.get_min(); i <= rx.get_max(); i=i+10) 
		{
			StdDraw.text(x[i]-0.07, -0.07, Double.toString(i-rangeX/2));
		}
		//y axis
		StdDraw.line((rangeX)/2, ry.get_min(), (rangeX)/2, ry.get_max());
		
		for (double i = ry.get_min(); i <= ry.get_max(); i=i+0.5) 
		{
			StdDraw.text(x[(int) (rangeX/2)]-0.07, i+0.07, Double.toString(i));
		}
		
		for (int i = 0; i < rangeX; i++) 
		{
			StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
>>>>>>> 13d47ae52bf91db299f8d797fed97115b661c75b
		}
	}

	@Override
	/**
	 * drawing the function from a json file
	 */
	public void drawFunctions(String json_file)
	{
		Gson gson = new Gson();
		try 
		{
			FileReader reader = new FileReader(json_file);
			param	parameters = gson.fromJson(reader,param.class);
			Range rx = new Range(0,0);
			rx = parameters.getRange(parameters.Range_X);
			Range ry = new Range(0,0);
			ry = parameters.getRange(parameters.Range_Y);
<<<<<<< HEAD
			this.drawFunctions(parameters.Width,parameters.Height,rx, ry,parameters.Resolution);
=======
			drawFunctions(parameters.Width,parameters.Height,rx, ry,parameters.Resolution);
>>>>>>> 13d47ae52bf91db299f8d797fed97115b661c75b
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
}