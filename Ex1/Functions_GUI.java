package Ex1;

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
		
	}

	@Override
	public void drawFunctions(String json_file)
	{

	}
}
