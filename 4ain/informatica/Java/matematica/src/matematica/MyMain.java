package matematica;

public class MyMain {

	public static void main(String[] args) {
		Ratio fr= new Ratio(2,3);
		fr.add(4, 3);
		System.out.println(fr);
		fr.sub(18, 6);
		System.out.println(fr);
		fr.mult(6, 3);
		System.out.println(fr);
		fr.div(8, 3);
		System.out.println(fr);
		fr.reciproc();
		System.out.println(fr);
		fr.pow(3);
		System.out.println(fr);
	}

}
