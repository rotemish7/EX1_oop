package Ex1;

public class ComplexFunction implements complex_function 
{
	function right;
	function left;
	Operation op;
	
	public  ComplexFunction(function f1) 
	{
		this.left = f1;
		this.right = null;
		this.op = Operation.None;
	}
	
	public  ComplexFunction(Operation op, function f1, function f2) 
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
		if(this.right == null) 
		{
			this.left = this;
			this.right = f1;
			this.op = Operation.Plus;
		} 
		else 
		{
			ComplexFunction CF = new ComplexFunction(this);
			this.left = CF;
			this.right = f1;
			this.op = Operation.Plus;
		}
	}
	/** Multiply this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be multiply be this complex_function.
	 */
	public void mul(function f1) 
	{
		if(this.right == null) 
		{
			this.left = this;
			this.right = f1;
			this.op = Operation.Times;
		} 
		else 
		{
			ComplexFunction CF = new ComplexFunction(this);
			this.left = CF;
			this.right = f1;
			this.op = Operation.Times;
		}
	}
	/** Divides this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be divid this complex_function.
	 */
	public void div(function f1) 
	{
		if(this.right == null) 
		{
			this.left = this;
			this.right = f1;
			this.op = Operation.Divid;
		} 
		else 
		{
			ComplexFunction CF = new ComplexFunction(this);
			this.left = CF;
			this.right = f1;
			this.op = Operation.Divid;
		}
	}
	/** Computes the maximum over this complex_function and the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be compared with this complex_function - to compute the maximum.
	 */
	public void max(function f1) 
	{
		if(this.right == null) 
		{
			this.left = this;
			this.right = f1;
			this.op = Operation.Max;
		} 
		else 
		{
			ComplexFunction CF = new ComplexFunction(this);
			this.left = CF;
			this.right = f1;
			this.op = Operation.Max;
		}		
	}
	/** Computes the minimum over this complex_function and the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be compared with this complex_function - to compute the minimum.
	 */
	public void min(function f1) 
	{
		if(this.right == null) 
		{
			this.left = this;
			this.right = f1;
			this.op = Operation.Min;
		} 
		else 
		{
			ComplexFunction CF = new ComplexFunction(this);
			this.left = CF;
			this.right = f1;
			this.op = Operation.Min;
		}
	}
	/**
	 * This method wrap the f1 complex_function with this function: this.f(f1(x))
	 * @param f1 complex function
	 */
	public void comp(function f1) 
	{
		if(this.right == null) 
		{
			this.left = this;
			this.right = f1;
			this.op = Operation.Comp;
		} 
		else 
		{
			ComplexFunction CF = new ComplexFunction(this);
			this.left = CF;
			this.right = f1;
			this.op = Operation.Comp;
		}
		
	}
	/** returns the left side of the complex function - this side should always exists (should NOT be null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function left() 
	{
		return this.left;
	}
	/** returns the right side of the complex function - this side might not exists (aka equals null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function right() 
	{
		return this.right;
	}
	/**
	 * The complex_function oparation: plus, mul, div, max, min, comp
	 * @return
	 */
	public Operation getOp() 
	{
		return this.op;
	}
	@Override
	public double f(double x) 
	{
		if (this.right == null) {
			return this.left.f(x);
		} else if (this.op == Operation.Plus) {
			return this.left.f(x)+this.right.f(x);
		} else if (this.op == Operation.Times) {
			return this.left.f(x)*this.right.f(x);
		} else if (this.op == Operation.Divid) {
			return this.left.f(x)/this.right.f(x);
		} else if (this.op == Operation.Max) {
			return Math.max(this.left.f(x),this.right.f(x));
		} else if (this.op == Operation.Min) {
			return Math.min(this.left.f(x),this.right.f(x));
		} else if( this.op == Operation.Comp) {
			return this.left.f(this.right.f(x));
		} else {
			return 0;
		}
	}
	/**
	 * @return function
	 * @ the method creating a new Function from a String
	 */
	@Override
	public function initFromString(String s) 
	{
		if (!s.contains("("))
		{
			Polynom p = new Polynom(s);
			return p;
		}
		int count=0, flag=0, j=0;
		Operation oper = Operation.None;
		function f = new ComplexFunction(null);
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(' && count == 0)
			{
				String str = s.substring(0, i);
				if (str.equals("Plus"))
				{
					oper = Operation.Plus;
				}
				else if (str.equals("Times"))
				{
					oper = Operation.Times;
				}
				else if (str.equals("Divid"))
				{
					oper = Operation.Divid;
				}
				else if (str.equals("Max"))
				{
					oper = Operation.Max;
				}
				else if (str.equals("Min"))
				{
					oper = Operation.Min;
				}
				else if (str.equals("Comp"))
				{
					oper = Operation.Comp;
				}
				count++;
				flag = 1;
				j=i;
			}
			if (s.charAt(i) == '(' && flag != 1)
			{
				count++;
				flag = 0;
			}
			if (s.charAt(i) == ')')
			{
				count--;
			}
			if (count == 1 && flag != 1)
			{
				String sub = s.substring(j+1, i+1);
				String sub2 = s.substring(i+2, s.length());
				function p1 = initFromString(sub);
				function p2 = initFromString(sub2);
				ComplexFunction cf = new ComplexFunction(oper, p1, p2);
				f=cf;
			}
			if (count == 0)
			{
				String [] sub = s.split(",");
				function p1 = initFromString(s.substring(j+1, sub[0].length()));
				function p2 = initFromString(sub[1].substring(0, sub[1].length()));
				ComplexFunction cf = new ComplexFunction(oper, p1, p2);
				f=cf;
			}
		}
		return f;
	}
	
	@Override
	public function copy() 
	{
		ComplexFunction CF = new ComplexFunction(this.op, this.left, this.right);
		return CF;
	}

	public String toString()
	{
		String ans = "";
		ans += this.op + "(" + this.left + ", " + this.right + ")";
		return ans;
	}
	
	public boolean equals(Object obj)
	{
		boolean flag = false;
		double ans=0, ans2=0;
		for (int i=-10; i<10; i++)
		{
			ans = this.f(i);
			if (obj.getClass() == Monom.class)
			{
				Monom m = (Monom) obj;
				ans2 = m.f(i);	
			}
			else if (obj.getClass() == Polynom.class)
			{
				Polynom p = (Polynom) obj;
				ans2 = p.f(i);
			}
			if (ans == ans2)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		}
		return flag;
	}
}
