package study;

interface I1{
	void m1();
}
interface I2 extends I1{
	void m1();
}
interface I3{
	void m1();
}
class A implements I3 {
	public void m3() {}
}
class B extends A implements I2 {
	public void m1() {}
	public void m2() {}
}


public class EX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		B b = new B();
		
		I1 i1 = b;
		I3 i3 = b;
		a= b;
	}

}
