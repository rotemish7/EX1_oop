package Ex1;

public class ComplexFunction implements complex_function 
{
	private function right;
	private function left;
	private Operation op;

	public  ComplexFunction(function f1) 
	{
		this.left = f1;
		this.right = null;
		this.op = Operation.None;
	}

	public ComplexFunction(Operation op, function f1, function f2) 
	{
		if (op == Operation.None && f2 != null)
		{
			T_exception();
		}
		if (f2 == null && op != Operation.None)
		{
			T_exception();
		}
		if (op == Operation.Error)
		{
			T_exception();
		}
		if (f1 == null)
		{
			T_exception();
		}
		this.left = f1;
		this.right = f2;
		this.op = op;
	}

	public ComplexFunction(String str, function polynom, function cf) 
	{
		if (polynom == null)
		{
			T_exception();
		}
		if (str.equals("plus") || str.equals("Plus"))
		{
			this.op = Operation.Plus;
		}
		else if (str.equals("mul") || str.equals("Times"))
		{
			this.op = Operation.Times;
		}
		else if (str.equals("div") || str.equals("Divide"))
		{
			this.op = Operation.Divid;
		}
		else if (str.equals("max") || str.equals("Max"))
		{
			this.op = Operation.Max;
		}
		else if (str.equals("min") || str.equals("Min"))
		{
			this.op = Operation.Min;
		}
		else if (str.equals("comp") || str.equals("Comp"))
		{
			this.op = Operation.Comp;
		}
		else if (str.equals("None") || str.equals("none") && cf == null)
		{
			this.op = Operation.None;
		}
		else if (str.equals("error") || str.equals("Error"))
		{
			T_exception();
		}
		if (cf == null && (!str.equals("none")))
		{
			T_exception();	
		}
		this.left = polynom;
		this.right = cf;
	}

	public static void T_exception()
	{
		try
		{ 
			throw new NullPointerException("Exception"); 
		} 
		catch(NullPointerException e) 
		{ 
			System.out.println("Not a valid ComplexFunction"); 
			throw e; // rethrowing the exception 
		} 
	}


	/** Add to this complex_function the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be added to this complex_function.
	 */
	public void plus(function f1) 
	{
		if(this.right == null) 
		{
			this.left = this.copy();
			this.right = f1;
			this.op = Operation.Plus;
		} 
		else 
		{
			if(this == f1)
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				ComplexFunction CF2 = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = CF2;
				this.op = Operation.Plus;
			}
			else
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = f1;
				this.op = Operation.Plus;
			}
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
			function temp = f1.copy();
			ComplexFunction new_left = new ComplexFunction(this.op,this.left,this.right);
			this.left = new_left;
			this.right = temp;
			this.op = Operation.Times;
		} 
		else 
		{
			if(this == f1)
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				ComplexFunction CF2 = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = CF2;
				this.op = Operation.Times;
			}
			else
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = f1;
				this.op = Operation.Times;
			}
		}
	}
	/** Divides this complex_function with the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be divid this complex_function.
	 */
	public void div(function f1) 
	{
		Polynom pZero = new Polynom ("0");
		if(this.right == null) 
		{
			this.left = this.copy();
			this.right = f1;
			this.op = Operation.Divid;
		} 
		else if (this.right == pZero)
		{
			T_exception();
		}
		else
		{
			if(this == f1)
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				ComplexFunction CF2 = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = CF2;
				this.op = Operation.Divid;
			}
			else
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = f1;
				this.op = Operation.Divid;
			}
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
			this.left = this.copy();
			this.right = f1;
			this.op = Operation.Max;
		} 
		else 
		{
			if(this == f1)
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				ComplexFunction CF2 = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = CF2;
				this.op = Operation.Max;
			}
			else
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = f1;
				this.op = Operation.Max;
			}
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
			this.left = this.copy();
			this.right = f1;
			this.op = Operation.Min;
		} 
		else 
		{
			if(this == f1)
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				ComplexFunction CF2 = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = CF2;
				this.op = Operation.Min;
			}
			else
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = f1;
				this.op = Operation.Min;
			}
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
			this.left = this.copy();
			this.right = f1;
			this.op = Operation.Comp;
		} 
		else 
		{
			if(this == f1)
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				ComplexFunction CF2 = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = CF2;
				this.op = Operation.Comp;
			}
			else
			{
				ComplexFunction CF = new ComplexFunction(this.op,this.left,this.right);
				this.left = CF;
				this.right = f1;
				this.op = Operation.Comp;
			}
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
		s = s.replaceAll("\\s+","");
		if (!s.contains("("))
		{
			Polynom p = new Polynom(s);
			this.left=p;
			this.right=null;
			this.op=Operation.None;
			return p;
		}
		int count=0, j=0;
		Operation oper = Operation.None;
		for (int i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == '(' && count == 0)
			{
				String str = s.substring(0, i);
				if (str.equals("plus") || str.equals("Plus"))
				{
					oper = Operation.Plus;
				}
				else if (str.equals("mul") || str.equals("Times"))
				{
					oper = Operation.Times;
				}
				else if (str.equals("div") || str.equals("Divid"))
				{
					oper = Operation.Divid;
				}
				else if (str.equals("max") || str.equals("Max"))
				{
					oper = Operation.Max;
				}
				else if (str.equals("min") || str.equals("Min"))
				{
					oper = Operation.Min;
				}
				else if (str.equals("comp") || str.equals("Comp"))
				{
					oper = Operation.Comp;
				}
				j=i;
			}
			if (s.charAt(i) == '(')
			{
				count++;
			}
			if (s.charAt(i) == ')')
			{
				count--;
			}
			if (count == 1 && (s.charAt(i+1) == ','))
			{
				String sub = s.substring(j+1, i+1);
				String sub2 = s.substring(i+2, s.length()-1);
				function p1 = initFromString(sub);
				function p11 = p1.copy();
				function p2 = initFromString(sub2);
				function p21 = p2.copy();
				this.left = p11;
				this.op = oper;
				this.right = p21;
				return this;
			}
			if (count == 0 && i == s.length()-1)
			{
				String [] sub = s.split(",");
				function p1 = initFromString(s.substring(j+1, sub[0].length()));
				function p2 = initFromString(sub[1].substring(0, sub[1].length()-1));
				this.left = p1;
				this.op = oper;
				this.right = p2;
				return this;
			} 
		}
		return this;
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
		if(this.right == null)
		{
			if(this.op == Operation.None)
			{
				ans += "(" + this.left + ")";
			}
			else
			{				
				T_exception();
			}
		}
		else
		{			
			ans += this.op + "(" + this.left + "," + this.right + ")";			
		}
		return ans;
	}

	public boolean equals(Object obj)
	{
		if(obj instanceof function)
		{
			if(obj instanceof Monom)
			{
				Monom m = (Monom)obj; 
				for (int i = -10; i <10; i++) 
				{
					if(this.f(i) != m.f(i))
					{
						return false;
					}
				}
				return true;
			}

			if(obj instanceof Polynom)
			{
				Polynom p = (Polynom)obj;
				
				for (int i = -10; i < 10; i++) 
				{
					if(this.f(i) != p.f(i))
					{
						return false;
					}
				}
				return true;
			}

			if(obj instanceof ComplexFunction)
			{			
				ComplexFunction cf = (ComplexFunction)obj;

				for (int i = -10; i < 10; i++) 
				{
					if(this.f(i) != cf.f(i))
					{
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}
