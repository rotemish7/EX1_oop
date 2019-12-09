package Ex1;

public class ComplexFunction implements complex_function {
	
	function right;
	function left;
	Operation op;
	
	public  ComplexFunction(function f1) {
		left = f1;
		right = null;
		op = Operation.None;
	}
	
	public  ComplexFunction(Operation op, function f1, function f2) {
		left = f1;
		right = f2;
		this.op = op;
	}
	
	/** Add to this complex_function the f1 complex_function
	 * 
	 * @param f1 the complex_function which will be added to this complex_function.
	 */
	public void plus(function f1) {
		if(this.right == null) {
			this.left = this;
			this.right = f1;
			this.op = Operation.Plus;
		} else {
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
	public void mul(function f1) {
		if(this.right == null) {
			this.left = this;
			this.right = f1;
			this.op = Operation.Times;
		} else {
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
	public void div(function f1) {
		if(this.right == null) {
			this.left = this;
			this.right = f1;
			this.op = Operation.Divid;
		} else {
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
	public void max(function f1) {
		if(this.right == null) {
			this.left = this;
			this.right = f1;
			this.op = Operation.Max;
		} else {
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
	public void min(function f1) {
		if(this.right == null) {
			this.left = this;
			this.right = f1;
			this.op = Operation.Min;
		} else {
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
	public void comp(function f1) {
		if(this.right == null) {
			this.left = this;
			this.right = f1;
			this.op = Operation.Comp;
		} else {
			ComplexFunction CF = new ComplexFunction(this);
			this.left = CF;
			this.right = f1;
			this.op = Operation.Comp;
		}
		
	}
	/** returns the left side of the complex function - this side should always exists (should NOT be null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function left() {
		return this.left;
	}
	/** returns the right side of the complex function - this side might not exists (aka equals null).
	 * @return a function representing the left side of this complex funcation
	 */
	public function right() {
		return this.right;
	}
	/**
	 * The complex_function oparation: plus, mul, div, max, min, comp
	 * @return
	 */
	public Operation getOp() {
		return this.op;
	}
	@Override
	public double f(double x) {
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
	@Override
	public function initFromString(String s) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public function copy() {
		
		return null;
	}

}
