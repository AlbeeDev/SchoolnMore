package matematica;

public class Ratio {
	private int n;
	private int d;
	public Ratio(int n,int d) {
		this.n=n;
		this.d=d;
	}
	
	
	
	
	
	public void add(int n,int d) {
		//mcm
		if(this.d!=d) {
			int den=this.d*d;
			this.n*=d;
			n*=this.d;
			this.d=den;
			d=den;
		}
		//operazione
		this.n+=n;
		//semplificazione
		if(this.d<0) {
			this.n=-this.n;
			this.d=-this.d;
		}
		int div=2;
		while ((this.n>1 || this.n<-1) && this.d>1){
			if(this.n%div==0 && this.d%div==0){
			this.d /= div;
			this.n /= div;
			}
			else
			div++;
		}
	}

	public void sub(int n,int d) {
		//mcm
		if(this.d!=d) {
			int den=this.d*d;
			this.n*=d;
			n*=this.d;
			this.d=den;
			d=den;
		}
		//operazione
		this.n-=n;
		//semplificazione
		if(this.d<0) {
			this.n=-this.n;
			this.d=-this.d;
		}
		int div=2;
		while ((this.n>1 || this.n<-1)  && this.d>1){
			if(this.n%div==0 && this.d%div==0){
			this.d /= div;
			this.n /= div;
			}
			else
			div++;
		}
	}
	
	public void mult(int n,int d) {
		//operazione
		this.n*=n;
		this.d*=d;
		//semplificazione
		if(this.d<0) {
			this.n=-this.n;
			this.d=-this.d;
		}
		int div=2;
		while ((this.n>1 || this.n<-1) && this.d>1){
			if(this.n%div==0 && this.d%div==0){
			this.d /= div;
			this.n /= div;
			}
			else
			div++;
		}
	}
	
	public void div(int n,int d) {
		//operazione
		this.n*=d;
		this.d*=n;
		//semplificazione
		if(this.d<0) {
			this.n=-this.n;
			this.d=-this.d;
		}
		int div=2;
		while ((this.n>1 || this.n<-1) && this.d>1){
			if(this.n%div==0 && this.d%div==0){
			this.d /= div;
			this.n /= div;
			}
			else
			div++;
		}
	}
	
	public void reciproc() {
		//operazione
		int t=this.n;
		this.n=this.d;
		this.d=t;
		//semplificazione
		if(this.d<0) {
			this.n=-this.n;
			this.d=-this.d;
		}
		int div=2;
		while ((this.n>1 || this.n<-1) && this.d>1){
			if(this.n%div==0 && this.d%div==0){
			this.d /= div;
			this.n /= div;
			}
			else
			div++;
		}
	}
	
	public void pow(int pw) {
		//operazione
		this.n=(int) Math.pow(this.n,pw);
		this.d=(int) Math.pow(this.d,pw);
		//semplificazione
		if(this.d<0) {
			this.n=-this.n;
			this.d=-this.d;
		}
		int div=2;
		while ((this.n>1 || this.n<-1) && this.d>1){
			if(this.n%div==0 && this.d%div==0){
			this.d /= div;
			this.n /= div;
			}
			else
			div++;
		}
	}

	@Override
	public String toString() {
		return "Frazione: "+n+"/"+d;
	}
	
	
}
