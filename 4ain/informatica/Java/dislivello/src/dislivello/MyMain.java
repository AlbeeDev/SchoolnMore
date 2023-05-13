package dislivello;

import java.util.Random;

public class MyMain {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=new Random().nextInt(1000);
			System.out.println(arr[i]);
		}
		int dismin=0,dismax=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>arr[i-1]) {
				dismax+=arr[i]-arr[i-1];
			}
			else {
				dismin-=arr[i-1]-arr[i];
			}
		}
		System.out.println();
		System.out.println(dismin);
		System.out.println(dismax);

	}

}
