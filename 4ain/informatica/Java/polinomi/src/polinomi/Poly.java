package polinomi;

public class Poly {
	private int[] polinomio;
	public Poly(int[] polinomio){
		this.polinomio = polinomio;
	}
	
	public Poly add(Poly p2) {
		if(polinomio.length!=p2.polinomio.length) {
			int[] sum=new int[Math.max(polinomio.length, p2.polinomio.length)];
			if(polinomio.length>p2.polinomio.length) {
				sum=polinomio.clone();
				for(int i=0;i<p2.polinomio.length;i++) {
					sum[i]+=p2.polinomio[i];
				}
			}
			else {
				sum=p2.polinomio.clone();
				for(int i=0;i<polinomio.length;i++) {
					sum[i]+=polinomio[i];
				}
			}
			
			
			return new Poly(sum);
		}
		else {
			for(int i=0;i<polinomio.length;i++) {
				polinomio[i]+=p2.polinomio[i];
			}
			
			return new Poly(polinomio);
		}
		
	}
	
	public Poly sub(Poly p2) {
		if(polinomio.length!=p2.polinomio.length) {
			int[] sub=new int[Math.max(polinomio.length, p2.polinomio.length)];
			if(polinomio.length>p2.polinomio.length) {
				sub=polinomio.clone();
				for(int i=0;i<p2.polinomio.length;i++) {
					sub[i]-=p2.polinomio[i];
				}
			}
			else {
				sub=p2.polinomio.clone();
				for(int i=0;i<polinomio.length;i++) {
					sub[i]-=polinomio[i];
				}
			}
			
			
			return new Poly(sub);
		}
		else {
			for(int i=0;i<polinomio.length;i++) {
				polinomio[i]-=p2.polinomio[i];
			}
			
			return new Poly(polinomio);
		}
	}
	
	public Poly mult(Poly p2) {
		int[][] mat=new int[polinomio.length][polinomio.length+p2.polinomio.length-1]; 
		for(int i=0;i<polinomio.length;i++) {
			for(int j=0;j<polinomio.length+p2.polinomio.length-1;j++) {
				mat[i][j]=0;
			}
		}
		for(int i=0;i<polinomio.length;i++) {
			for(int j=0;j<p2.polinomio.length;j++) {
				int k=i+j;
				mat[i][k]+=polinomio[i]*p2.polinomio[j];
			}
		}
		int[] arr=mat[0].clone();
		for(int i=1;i<polinomio.length;i++) {
			for(int j=0;j<polinomio.length+p2.polinomio.length-1;j++) {
				arr[j]+=mat[i][j];
			}
		}
		
		
		return new Poly(arr);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		str.append(polinomio[0]+"x^"+0);
		for(int i=1; i<polinomio.length;i++) {
			if(polinomio[i]<0) {
				str.append(" - "+-polinomio[i]+"x^"+i);
			}
			else {
				str.append(" + "+polinomio[i]+"x^"+i);
			}
		}
		
		return str.toString();
	}
	
}
