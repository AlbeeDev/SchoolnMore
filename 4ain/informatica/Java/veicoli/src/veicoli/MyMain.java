package veicoli;


public class MyMain {

	public static void main(String[] args) {
		
		Automobile auto1 = new Automobile(4,5);
		System.out.println(auto1);
		System.out.println("Litri inseriti: " + auto1.fill(20));
		System.out.println(auto1);
		System.out.println("Litri inseriti: " + auto1.fill(30));
		auto1.move();
		System.out.println(auto1);
		
		Aereo aereo1 = new Aereo(10,20);
		System.out.println(aereo1);
		System.out.println("Litri inseriti: " + aereo1.fill(1000));
		System.out.println(aereo1);
	}

}
