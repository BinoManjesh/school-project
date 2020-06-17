public class Test {

	public static void main(String[] args)  {
		C c = new C();
	}

	private static class C extends B {
		C() {
			System.out.println("C's constructor");
		}
	}

	private static class B extends A {
		B() {
			System.out.println("B's constructor");
		}
	}

	private static class A {
		A(int b) {}
	}
}