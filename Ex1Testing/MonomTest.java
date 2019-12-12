package Ex1Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Ex1.Monom;

public class MonomTest {

	Monom [] mArr;
	Monom m0,m1,m2,m3,m4;

	@Before
	public void insert() {
		// 2, -1, -3.2x^2, 0, 5x^3
		mArr = new Monom[5];
		m0 = new Monom (2,0);
		m1 = new Monom (-1,1);
		m2 = new Monom (-3.2,2);
		m3 = new Monom (0,0);
		m4 = new Monom (5,3);
		mArr[0] = m0;
		mArr[1] = m1;
		mArr[2] = m2;
		mArr[3] = m3;
		mArr[4] = m4;
	}

	@After
	public void reset() 
	{
		for (int i=0; i<mArr.length; i++) 
		{
			mArr[i] = null;
		}
	}

	@Test
	public void testGetCoe() 
	{
		double [] ansCoe = {2,-1,-3.2,0,5};
		for(int i=0; i>mArr.length; i++) 
		{
			double coe = mArr[i].get_coefficient();
			assertEquals("Test f:",coe,ansCoe[i],0.00001);
		}
	}

	@Test
	public void testGetPow() 
	{
		double [] ansPow = {0,1,2,0,3};
		for(int i=0; i>mArr.length; i++) 
		{
			double pow = mArr[i].get_power();
			assertEquals("Test f:",pow,ansPow[i],0.00001);
		}
	}

	@Test
	public void testIsZero()
	{
		for(int i=0; i<mArr.length; i++) 
		{
			try
			{
			mArr[i].isZero();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

	@Test
	public void testDerivative() 
	{
		Monom [] ansDer = {new Monom ("0"), new Monom ("-1"), new Monom ("-6.4x"), new Monom ("0"), new Monom ("15x^2")} ;
		for(int i=0; i<mArr.length; i++) 
		{
			Monom der = mArr[i].derivative();
			assertEquals("Test derivative:",der,ansDer[i]);
		}
	}

	@Test
	public void testF() 
	{
		double [] ansF = {2,1,-3.2,0,-5};
		for(int i=0; i<mArr.length; i++) 
		{
			double f = mArr[i].f(-1);
			double ans = ansF[i];
			assertEquals("Test f:",f,ans,0.00001);
		}
	}

	@Test
	public void testStringAndMonom() 
	{
		String[] monoms = {"+2.0", "-1.0x","-3.2x^2","0","+5.0x^3"};
		for(int i=0; i<mArr.length; i++) 
		{
			Monom m = new Monom(monoms[i]);
			String s = m.toString();
			assertEquals("Test toString: ", s, monoms[i]);
			m = new Monom(s);
			assertEquals("Test Monom(s): ", m, mArr[i]);
		}		
	}

	@Test
	public void testAdd() 
	{
		for(int i=0; i<mArr.length; i++) 
		{
			try
			{
				mArr[i].add(new Monom(-1,0));
				mArr[i].add(new Monom (0.2,2));
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	@Test
	public void testMult() 
	{
		Monom [] ansMul = {new Monom (-2,0) ,new Monom (1,1) ,new Monom (3.2,2), new Monom (0,0) ,new Monom (-5,3)};
		for(int i=0; i<mArr.length; i++) 
		{
				mArr[i].multipy(new Monom(-1,0));
				assertEquals("Test multipy", mArr[i], ansMul[i]);
		}
	}

	@Test
	public void testEquals() 
	{
		String[] monoms = {"2", "-x","-3.2x^2","0","5x^3"};
		for (int i=0; i<monoms.length; i++) 
		{
			Monom m = new Monom(monoms[i]);
			String s = m.toString();
			Monom m1 = new Monom(s);
			assertTrue("Test equal: ", m.equals(m1));
		}
	}

	@Test
	public void testInitFromString()
	{
		String[] monoms = {"2", "-x","-3.2x^2","0","5x^3"};
		for (int i=0; i<monoms.length; i++) 
		{
			Monom m = new Monom (0,0);
			m.initFromString(monoms[i]);
			assertEquals("Test initFromString: ", m, mArr[i]);
		}
	}

	@Test
	public void testCopy() 
	{
		Monom [] copy = new Monom [5];
		for(int i=0; i<mArr.length; i++) 
		{
			copy[i] = (Monom) mArr[i].copy();
			assertEquals("Test copy: ", mArr[i], copy[i]);
		}
	}

}
