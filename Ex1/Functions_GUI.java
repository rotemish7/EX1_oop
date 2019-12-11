package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Functions_GUI implements functions 
{
	ArrayList<function> funcs = new ArrayList<function>();

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
	public void initFromFile(String file) throws IOException 
	{
		String csvFile = file;
		String line = "";

		try 
		{
			BufferedReader br = new BufferedReader(new FileReader(csvFile));
			int i = 0;
			while ((line = br.readLine()) != null) 
			{
				funcs.get(i++).initFromString(line);
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("could not read file");
		}
	}

	@Override
	public void saveToFile(String file) throws IOException 
	{
		String fileName = "functions.txt";

		try 
		{
			PrintWriter pw = new PrintWriter(new File(fileName));
			StringBuilder sb = new StringBuilder();

			for(int i=0; i<funcs.size(); i++)
			{
				sb.append(funcs.get(i).toString());
				sb.append("\n");
			}
			pw.write(sb.toString());
			pw.close();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution)
	{
		double ranX = rx.get_max()-rx.get_min();
		double []x = new double [(int) ranX];
		for (int j=0; j<funcs.size(); j++)
		{
			for (int i=0; i<x.length; i++)
			{
				x[i] = funcs.get(j).f(i);
			}
		}

		StdDraw.setCanvasSize(width, height);
		// rescale the coordinate system
		StdDraw.setXscale(rx.get_min(), rx.get_max());
		StdDraw.setYscale(ry.get_min(), ry.get_max());
		
		//vertical lines
		StdDraw.setPenColor(Color.LIGHT_GRAY);
		for (int i = (int) rx.get_min(); i <= rx.get_max(); i++) {
			StdDraw.line(x[i], ry.get_min(), x[i], ry.get_max());
		}
		//horizontal lines
		for (double i = ry.get_min(); i <= ry.get_max(); i++) {
			StdDraw.line(rx.get_min(), i, rx.get_max(), i);
		}
		//x axis
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.setPenRadius(0.005);
		StdDraw.line(rx.get_min(), (ry.get_max()-ry.get_min())/2, rx.get_max(), (ry.get_max()-ry.get_min())/2);
		StdDraw.setFont(new Font("TimesRoman", Font.BOLD, 15));
		for (int i = (int) rx.get_min(); i <= rx.get_max(); i=i+10) {
			StdDraw.text(x[i]-0.07, -0.07, Double.toString(i-ranX/2));
		}
		//y axis
		StdDraw.line((ranX)/2, ry.get_min(), (ranX)/2, ry.get_max());
		for (double i = ry.get_min(); i <= ry.get_max(); i=i+0.5) {
			StdDraw.text(x[(int) (ranX/2)]-0.07, i+0.07, Double.toString(i));
		}
	}

	@Override
	public void drawFunctions(String json_file)
	{

	}
}