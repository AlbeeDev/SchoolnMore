package polinomi;

public class MyMain {

	public static void main(String[] args) {
		Poly p = new Poly(new int[] {-2,+3});
		System.out.println(p);
		Poly p2 = new Poly(new int[] {6,4,0,6});
		System.out.println(p2);
		System.out.println(p.add(p2));
		System.out.println(p.sub(p2));
		System.out.println(p.mult(p2));
	}

}