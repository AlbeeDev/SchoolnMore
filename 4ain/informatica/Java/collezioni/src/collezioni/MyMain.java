package collezioni;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class MyMain {

	public static void main(String[] args) {
		//1
		Collection<Integer> list= new ArrayList<>();
		for(int i=0;i<10;i++) {
			list.add(new Random().nextInt(100));
		}
		//2
		for(Integer value : list){
			System.out.print(value+" ");
		}
		System.out.println(" ");
		//3
		for(int i=0;i<2;i++) {
			Integer value;
			do {
				value=new Random().nextInt(100);
			}while(list.remove(value)==false);
		}
		//4
		for(Integer value : list){
			if(value%2!=0) {
				System.out.println(value+" dispari");
			}
		}
		
	}
	
}
