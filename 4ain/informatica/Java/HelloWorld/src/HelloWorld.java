import java.io.BufferedReader;
import java.text.DecimalFormat;
public class HelloWorld {

	public static void main(String[] args) throws java.io.IOException {
		BufferedReader stdin= new BufferedReader(
				new java.io.InputStreamReader(
						System.in
						)
				);
		System.out.println("Inserisci il primo numero: ");
		String str1 = stdin.readLine();
		System.out.println("Inserisci il secondo numero: ");
		String str2 = stdin.readLine();
		System.out.println("Inserisci il terzo numero: ");
		String str3 = stdin.readLine();
		DecimalFormat frmt = new DecimalFormat();
		float var3= Float.parseFloat(str3);
		frmt.setMaximumFractionDigits(1);
		System.out.printf("il terzo numero inserito è  : ",frmt.format(var3));
		float var2 = Float.parseFloat(str2);
		frmt.setMaximumFractionDigits(2);
		System.out.printf("il secondo numero inserito è: ",frmt.format(var2));
		float var1 = Float.parseFloat(str1);
		frmt.setMaximumFractionDigits(3);
		System.out.printf("il primo numero inserito è  : ",frmt.format(var1));

	}

}
