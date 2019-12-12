package Ex1Testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Ex1.ComplexFunction;
import Ex1.Monom;
import Ex1.Operation;
import Ex1.Polynom;
import Ex1.function;

public class ComplexFunctionTest {

	ComplexFunction cf, cf1, cf2, cf3, cf4;
	
	@Before
	public void insert()
	{
		cf = new ComplexFunction(new Polynom ("4+2x"));
		cf1 = new ComplexFunction(Operation.Times, new Polynom ("x+3"), new Polynom ("x-2"));
		cf2 = new ComplexFunction ("div", new Monom (5,4), cf1);
		cf3 = new ComplexFunction(Operation.Max, new Polynom ("9+x"), new Polynom ("2x^2-6x"));
		cf4 = new ComplexFunction ("div", cf1, new Monom (5,4));
	}
	
	@Test
	public void testComplexString()
	{
		String str = "mul";
		function f1 = new Polynom ("x+3");
		function f2 = new Polynom ("x-2");
		ComplexFunction cf2 = new ComplexFunction(str, f1, f2);
		assertTrue("Test CS: ", cf1.equals(cf2));
		try 
		{
			ComplexFunction cf4 = new ComplexFunction("div", f1, null);
			ComplexFunction cf5 = new ComplexFunction("none", f1, f2);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@Test
	public void testComplexOp() 
	{
		Operation op = Operation.Max;
		function f1 = new Polynom ("9+x");
		function f2 = new Polynom ("2x^2-6x");
		ComplexFunction cf2 = new ComplexFunction(op, f1, f2);
		assertTrue("Test CS: ", cf3.equals(cf2));
		
	}
	
	@Test
	public void testPlus()
	{
		function f1 = new Polynom ("x+3");
		ComplexFunction cf4 = new ComplexFunction("plus", cf.copy(), f1.copy());
		cf.plus(f1);
		assertTrue("Test plus: ", cf.equals(cf4));
	}
	
	@Test
	public void testMul()
	{
		function f1 = new Polynom ("x+3");
		ComplexFunction cf4 = new ComplexFunction("mul", cf.copy(), f1);
		cf.mul(f1);
		assertTrue("Test mul: ", cf.equals(cf4));
	}
	
	@Test
	public void testDiv() 
	{
		// throw error if divide with zero
		try
		{
		Polynom zero = new Polynom ("0");
		cf1.div(zero);
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		// regular div
		function f1 = new Polynom ("x+3");
		ComplexFunction cf4 = new ComplexFunction("div", cf.copy(), f1.copy());
		cf.div(f1);
		assertTrue("Test div: ", cf.equals(cf4));
	}
	
	@Test
	public void testMax() 
	{
		function f1 = new Polynom ("x+3");
		ComplexFunction cf4 = new ComplexFunction("max", cf.copy(), f1.copy());
		cf.max(f1);
		assertTrue("Test max: ", cf.equals(cf4));
	}
	
	@Test
	public void testMin() 
	{
		function f1 = new Polynom ("x+3");
		ComplexFunction cf4 = new ComplexFunction("min", cf.copy(), f1.copy());
		cf.min(f1);
		assertTrue("Test min: ", cf.equals(cf4));
	}
	
	@Test
	public void testComp() 
	{
		function f1 = new Polynom ("x+3");
		ComplexFunction cf4 = new ComplexFunction("comp", cf.copy(), f1.copy());
		cf.comp(f1);
		assertTrue("Test comp: ", cf.equals(cf4));
	}
	
	@Test
	public void testLeft() 
	{
		function f = new Polynom ("4+2x");
		assertTrue("Test left: ", f.equals(cf.left()));
	}
	
	@Test
	public void testRight() 
	{
		// when right == null
		assertEquals(null, cf.right());
		assertEquals(cf1, cf2.right());
		
		// when right == polynom
		function f = new Polynom ("2x^2-6x");
		assertTrue(cf3.right().equals(f));
	}
	
	@Test
	public void testGetOp() 
	{
		Operation op = cf.getOp();
		assertTrue(op.equals(Operation.None));
		Operation op1 = cf1.getOp();
		assertTrue(op1.equals(Operation.Times));
		Operation op2 = cf2.getOp();
		assertTrue(op2.equals(Operation.Divid));
		Operation op3 = cf3.getOp();
		assertTrue(op3.equals(Operation.Max));
	}
	
	@Test
	public void testF() 
	{
		int ans = 6;
		double f = cf.f(1);
		assertEquals("Test f: ", f,ans, 0.0001);
		f = cf1.f(0);
		assertEquals("Test f: ", f,-ans, 0.0001);
	}
	
	@Test
	public void testInitFromString() 
	{
		// the string with the shorten for names of operation
		String str = "div(5.0x^4,mul(+1.0x+3.0,+1.0x-2.0))";
		function f = new ComplexFunction(null);
		f.initFromString(str);
		assertTrue("Test initFromString: ", f.equals(cf2));
		
		// the string with the real names of operation
		str = "Divid(+5.0x^4,Times(+1.0x+3.0,+1.0x-2.0))";
		f = new ComplexFunction(null);
		f.initFromString(str);
		assertTrue("Test initFromString: ", f.equals(cf2));
		
		// the string is polynom
		f = new ComplexFunction(null);
		str = "-1.0x^4 +2.4x^2 +3.1";
		f.initFromString(str);
		cf2 = new ComplexFunction(Operation.None, new Polynom ("-x^4+2.4x^2+3.1"),null);
		assertTrue("Test initFromString: ", f.equals(cf2));
	}
	
	@Test
	public void testCopy() 
	{
		cf = new ComplexFunction(Operation.Divid, new Polynom ("6+4x"), new Polynom ("8x"));
		function cf2 = cf.copy();
		assertTrue("Test copy: " , cf.equals(cf2));
	}
	
	@Test
	public void testToString()
	{
		String str = "Divid(+5.0x^4,Times(+1.0x+3.0,+1.0x-2.0))";
		String s = cf2.toString();
		assertEquals("Test toString: ", s, str);
	}
	
	@Test
	public void testEquals() 
	{
		String str = "Divid(+5.0x^4,Times(+1.0x+3.0,+1.0x-2.0))";
		function f = new ComplexFunction(null);
		f.initFromString(str);
		assertTrue("Test initFromString: ", f.equals(cf2));
	}
}
