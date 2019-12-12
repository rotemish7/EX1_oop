package Ex1Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ex1.Monom;
import Ex1.Polynom;
import Ex1.Polynom_able;

public class PolynomTest {

	Polynom p;

	@Test
	public void testToStringAndPolynom()
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		String strP = "+5.0x^3-3.2x^2-1.0x+2.0";
		String s = p.toString();
		assertEquals("Test toString: ", s, strP);
		Polynom p1 = new Polynom(s);
		assertTrue("Test Polynom(s): ", p1.equals(p));
	}

	@Test
	public void testF()
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		double ansF = -5.2;
		double f = p.f(-1);
		assertEquals("Test f: ",ansF, f,0.00001);	
	}

	@Test
	public void testAddPol()
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		Polynom p1 = new Polynom ("2-x");
		Polynom p2 = new Polynom ("5.x^3-3.2x^2+4-2x");
		p.add(p1);
		assertTrue("Test add polynom: ", p.equals(p2));
	}

	@Test
	public void testAddMon()
	{
		Polynom p1 = new Polynom();
		Monom m = new Monom (1,1);
		p1.add(m);
		assertTrue("Test add monom:", p1.equals(m));
	}

	@Test
	public void testSubstract()
	{
		// substract polynom with self
		p = new Polynom ("2-x-3.2x^2+5x^3");
		p.substract(p);
		assertTrue("Test sub: ", p.isZero());
		
		// substract polynom and monom
		p = new Polynom ("2-x-3.2x^2+5x^3");
		Polynom ans = new Polynom ("2-x-3.2x^2");
		Polynom m = new Polynom ("5x^3");
		p.substract(m);
		assertTrue("Test sub: ", p.equals(ans));
		
		// substract 2 polynoms
		p = new Polynom ("2-x-3.2x^2+5x^3");
		Polynom p1 = new Polynom ("2-3.2x^2");
		ans = new Polynom ("-x+5x^3");
		p.substract(p1);
		assertTrue("Test sub: ", p.equals(ans));
	}

	@Test
	public void testMul()
	{
		// multiply with zero Polynom
		p = new Polynom ("2-x-3.2x^2+5x^3");
		p.multiply(new Monom (0,0));
		assertTrue("Test mulMonom: ", p.isZero());
		
		// multiply with monom
		Polynom p1 = new Polynom();
		p1.add(new Monom(1,1));
		p = new Polynom ("2-x-3.2x^2+5x^3");
		p.multiply(p1);
		String strP2 = "2x-x^2-3.2x^3+5x^4";
		Polynom p2 = new Polynom(strP2);
		assertTrue("Test mulMonom: ", p.equals(p2));
		
		// multiply with polynom
		p = new Polynom ("2-x-3.2x^2+5x^3");
		p1.add(new Monom (1,0));
		p.multiply(p1);
		strP2 = "+5.0x^4+1.7999999999999998x^3-4.2x^2+1.0x+2.0";
		p2 = new Polynom(strP2);
		assertTrue("Test mulMonom: ", p.equals(p2));
	}

	@Test
	public void testIsZero()
	{
		Polynom p1 = new Polynom();
		p1.add(new Monom(0,0));
		try
		{
			p.isZero();
			p1.isZero();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}

	@Test
	public void testRoot()
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		double root = -0.6420036405324936;
		double pRoot = p.root(-50, 84, 0.000001);
		assertEquals("Test root: ", pRoot, root, 0.00001);
	}

	@Test
	public void testDer()
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		Polynom p1 = new Polynom ();
		p1.add(new Monom(-1,0));
		p1.add(new Monom(-6.4,1));
		p1.add(new Monom(15,2));
		assertTrue("Test der: ", p1.equals(p.derivative()));
	}

	@Test
	public void testArea() 
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		double area = 1.6835733404998956;
		double pArea = p.area(0, 1, 0.0001);
		assertEquals("Test area: " , pArea, area, 0.00001);
	}


	@Test
	public void testInitFromString()
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		String p1 = "2-x-3.2x^2+5x^3";
		Polynom p2 = new Polynom();
		p2.initFromString(p1);
		assertTrue("Test initFromString: ", p2.equals(p));
	}

	@Test
	public void testCopy()
	{
		p = new Polynom ("2-x-3.2x^2+5x^3");
		Polynom p1 = (Polynom) p.copy();
		assertTrue("Test copy: ", p1.equals(p));
	}

	@Test
	public void testEqualsObj()
	{
		// check if monom equals to polynom
		Monom m1 = new Monom (-1,1);
		Polynom p1 = new Polynom();
		p1.add(m1);
		assertEquals("Test eqObjMonom: ", m1,p1);
		
		// check if polynom equals to polynom
		p = new Polynom ("2-x-3.2x^2+5x^3");
		Polynom p2 = new Polynom();
		p2.add(m1);
		p2.add(new Monom (5,3));
		p2.add(new Monom (2,0));
		p2.add(new Monom (-3.2,2));
		assertTrue("Test eqObjPolynom: ", p.equals(p2));
	}

}
