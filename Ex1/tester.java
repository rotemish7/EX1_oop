package Ex1;

public class tester 
{

	public static void main(String[] args) 
	{
//		Monom m1 = new Monom(2,3);
//		Monom m2 = new Monom(1,3);
//		Polynom p = new Polynom("2x");
//		System.out.println(m1.equals(p));
//		
//		String str1 = "3x^3+x^2+3";
//		String str2 = "3x^3";
//		String str3 = "x^2+3x";
//		function f1 = new Monom(0,0);
//		function f2 = new Polynom();
//		function f3 = new Polynom(str3);
//		System.out.println(f3.toString());
//		f1.initFromString(str2); 
//		f2.initFromString(str1);
//		
//		String s = f1.toString();
//		System.out.println("f1 string = " + s);
//	    System.out.println("f1 = " + f1);
//		System.out.println("f2 = " + f2);
//		System.out.println(f2.equals(f2));
//		System.out.println(f1.equals(f3));
//		
//		ComplexFunction cf = new ComplexFunction(Operation.Plus, f2, f3);
//		ComplexFunction cf2 = new ComplexFunction(Operation.Divid, cf , f2);
//		ComplexFunction cf3 = new ComplexFunction(Operation.Max, cf , cf2);
//		System.out.println("Operation.Plus, f2 , f3");
//		System.out.println("Operation.Divid, cf , f2");
//		System.out.println("Operation.Max, cf , cf2");
//		System.out.println(cf3.toString());
		
		//String str = "Max(Plus(+3.0x^3+1.0x^2+3.0,+1.0x^2+3.0x),Divid(Plus(+3.0x^3+1.0x^2+3.0,+1.0x^2+3.0x),+3.0x^3+1.0x^2+3.0))";
		String str = "Plus(+3.0x^3+1.0x^2+3.0,+1.0x^2+3.0x)";
		function f8 = new ComplexFunction(null);
		f8.initFromString(str);
		System.out.println(f8.toString());
		
		
		
	}
}
