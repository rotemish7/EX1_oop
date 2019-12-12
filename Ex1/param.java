package Ex1;

public class param 
{
	int Width;
	int Height;
	int Resolution;
	int[] Range_X;
	int[] Range_Y;
	
	public Range getRange(int[]x)
	{
		int min = x[0];
		int max = x[1];
		return new Range (min,max);
	}
	
}
