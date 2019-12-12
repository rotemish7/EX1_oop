package Ex1;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import Ex1.Polynom;
import Ex1.Range;
import Ex1.StdDraw;
import Ex1.function;
public class testSTD
{
	public static functions FunctionsFactory()
	{
		functions ans = new Functions_GUI();
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x+3","x-2","x-4"};
		Polynom p1 = new Polynom(s1);
		Polynom p2 = new Polynom(s2);
		Polynom p3 = new Polynom(s3[0]);
		ComplexFunction cf3 = new ComplexFunction(p3);
		for(int i=1;i<s3.length;i++) 
		{
			cf3.mul(new Polynom(s3[i]));
		}
		
		ComplexFunction cf = new ComplexFunction(Operation.Plus, p1,p2);
		ComplexFunction cf4 = new ComplexFunction("div",new Polynom("x+1"),cf3);
		cf4.plus(new Monom("2"));
		ans.add(cf.copy());
		ans.add(cf4.copy());
		cf.div(p1);
		ans.add(cf.copy());
		String s = cf.toString();
		function cf5 = cf4.initFromString(s1);
		function cf6 = cf4.initFromString(s2);
		ans.add(cf5.copy());
		ans.add(cf6.copy());
		Iterator<function> iter = ans.iterator();
		function f = iter.next();
		ComplexFunction max = new ComplexFunction(f);
		ComplexFunction min = new ComplexFunction(f);
		while(iter.hasNext()) 
		{
			f = iter.next();
			max.max(f);
			min.min(f);
		}
		ans.add(max);
		ans.add(min);		
		return ans;
	}

	public static void main(String[] args) 
	{
		ArrayList<function> f = new ArrayList<function>();
		
		function f1 = new Polynom("x");
		function f2 = new Polynom("x^2-3x+5x^3");
		function f3 = new Polynom("x^3-20-x^2");
		function f4 = new Polynom("x^4+20-3x^3-5x");		
		function f5 = new Polynom("x^5-4x^2+3x");		
		function f6 = new Polynom("x^6-30x-x^4");
		function f7 = new Polynom("x^7-x+x^5-x^3");
		function f8 = new Polynom("x^8-10x^2+4x^4+x^3");
		
		System.out.println("f1 = " + f1.toString());
		f1.initFromString("x^8");
		System.out.println("f1 init = " + f1.toString());
	
		
		
//		function f = new Polynom("x");
////		Polynom p = new Polynom("x^2-3x+5x^3");
////		Polynom p2 = new Polynom("x^2-3x+5x^3+x^5");
////		System.out.println(p.toString());
////		System.out.println(p2.toString());
////		p2.substract(p);
////		System.out.println(p2.toString());	
//		function f2 = new Polynom("x^2-3x+5x^3");
//		function f3 = new Polynom("x^3-20-x^2");
//		function f4 = new Polynom("x^4+20-3x^3-5x");
//		function f5 = new Polynom("x^5-4x^2+3x");
//		function f6 = new Polynom("x^6-30x-x^4");
//		function f7 = new Polynom("x^7-x+x^5-x^3");
//		function f8 = new Polynom("x^8-10x^2+4x^4+x^3");
//	
//		ComplexFunction cf = new ComplexFunction(Operation.None,f,null);
//		System.out.println(cf.toString());
//		function cf2 = cf.copy();
//		System.out.println("Copy = " +cf2.toString());
//		function f10 = cf;
//		cf.mul(f10);
//		System.out.println(cf.toString());
////		ComplexFunction cf4 = new ComplexFunction("div",new Polynom("x+1"),cf);
////		System.out.println(cf4.toString());
//		Functions_GUI data2 = new Functions_GUI();
//		data2.funcs.add(f);
//		data2.funcs.add(f2);
//		data2.funcs.add(f3);
//		data2.funcs.add(f4);
//		data2.funcs.add(f5);
//		data2.funcs.add(f6);
//		data2.funcs.add(f7);
//		data2.funcs.add(f8);
//		data2.funcs.add(cf);
//		Range rx = new Range(-20,20);
//		Range ry = new Range(-20,20);
//		int resolution = 200;
//		data2.drawFunctions(1000,1000,rx,ry,resolution);
//		data2.drawFunctions("GUI_params.txt");
		
		functions ans = new Functions_GUI();
		String s1 = "3.1+2.4x^2-x^4";
		String s2 = "5+2x-3.3x+0.1x^5";
		String[] s3 = {"x+3","x-2","x-4"};
		Polynom p1 = new Polynom(s1);
		System.out.println("p1 = "+p1.toString());
		Polynom p2 = new Polynom(s2);
		System.out.println("p2 = "+p2.toString());
		Polynom p3 = new Polynom(s3[0]);
		System.out.println("p3 = "+ p3.toString());
		ComplexFunction cf3 = new ComplexFunction(p3);
		System.out.println("cf3 = " + cf3.toString());
		for(int i=1;i<s3.length;i++) 
		{
			cf3.mul(new Polynom(s3[i]));
			System.out.println("cf3 = " +cf3.toString());
		}
		
		ComplexFunction cf = new ComplexFunction(Operation.Plus, p1,p2);
		System.out.println("cf = " + cf.toString());
		ComplexFunction cf4 = new ComplexFunction("div",new Polynom("x+1"),cf3);
		System.out.println("cf4 = " + cf4.toString());
		cf4.plus(new Monom("2"));
		System.out.println("cf4 = " + cf4.toString());
		ans.add(cf.copy());
		ans.add(cf4.copy());
		cf.div(p1);
		ans.add(cf.copy());
		String s = cf.toString();
		function cf5 = cf4.initFromString(s1);
		System.out.println("cf5 = " + cf5.toString());
		function cf6 = cf4.initFromString(s2);
		System.out.println("cf6 = " + cf6.toString());
		ans.add(cf5.copy());
		ans.add(cf6.copy());
		Iterator<function> iter = ans.iterator();
		function f10 = iter.next();
		ComplexFunction max = new ComplexFunction(f10);
		System.out.println("max = " +max.toString());
		ComplexFunction min = new ComplexFunction(f10);
		System.out.println("min =" + min.toString());
		while(iter.hasNext()) 
		{
		f10 = iter.next();
			max.max(f10);
			min.min(f10);
		}
		ans.add(max);
		ans.add(min);	

	}
}
