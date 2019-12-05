package myMath;

public class ComplexFunction implements complex_function
{
	function right;
	function left;
	Operation op;
	
	public ComplexFunction(function f1)
	{
		this.left = f1;
		this.right = null;
		this.op = Operation.None;
	}
	
	public ComplexFunction(Operation op, function f1, function f2)
	{
		this.left = f1;
		this.right = f2;
		this.op = op;
	}
	/** Add to this complex_function the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be added to this complex_function.
	 */
	public void plus(function f1)
	{
		
	}
	/** Multiply this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be multiply be this complex_function.
	 */
	public void mul(function f1)
	{
		
	}
	/** Divides this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be divid this complex_function.
	 */
	public void div(function f1)
	{
		
	}
	/** Computes the maximum over this complex_function and the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be compared with this complex_function - to compute the maximum.
	 */
	public void max(function f1)
	{
		
	}
	/** Computes the minimum over this complex_function and the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be compared with this complex_function - to compute the minimum.
	 */
	public void min(function f1)
	{
		
	}
	/**
	 * This method wrap the f1 complex_function with this function: this.f(f1(x))
	 * @param f1 complex function
	 */
	public void comp(function f1)
	{
		
	}
	/** returns the left side of the complex function - this side should always exists (should NOT be null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function left()
	{
		
	}
	/** returns the right side of the complex function - this side might not exists (aka equals null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function right()
	{
		
	}
	/**
	 * The complex_function oparation: plus, mul, div, max, min, comp
	 * @return
	 */
	public Operation getOp()
	{
		
	}
}
