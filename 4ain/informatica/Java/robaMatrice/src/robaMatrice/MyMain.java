package robaMatrice;

import java.util.Random;

public class MyMain {

	public static void main(String[] args) {
		
		int len=5;
		
		triMat(genMatrix(len),len);
	}

	public static int[][] genMatrix(int len) {
	
		int[][] mat= new int[len][len];
		
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				if(j==len) {
					mat[i][j]=0;
				}
				else {
					mat[i][j]=new Random().nextInt(10);
				}
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
		return mat;
		
	}
	
	public static void triMat(int[][] mat,int len) {
		
		int k=0;
		
		for(int i=0;i<len;i++) {
			if(mat[i][k]==0) {
				findNonZero(mat, len, i, k);
			}
			if((i==len-1) && (k<len-1)) {
				i=0;
				k+=1;
			}
		}
		System.out.println();
		printMat(mat,len);
	}
	
	public static void findNonZero(int[][] mat,int len,int r,int c) {
		
		for(int i=r;i<len;i++) {
			if(mat[i][c]!=0) {
				int[] temp=mat[i];
				mat[i]=mat[r];
				mat[r]=temp;
			}
		}
	}
	
	public static void printMat(int[][] mat,int len) {
		for(int i=0;i<len;i++) {
			for(int j=0;j<len;j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
}