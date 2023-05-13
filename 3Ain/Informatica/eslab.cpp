#include <graphics.h>
#include <math.h>
int main(){
	int gd = DETECT, gm;
	int vecx[5]={3,5,12,9,5};
	int vecy[5]={4,11,8,5,6};
	size_t n=sizeof(vecx)/sizeof(vecx[0]);
	for(size_t i=0;i<n;i++){
		vecx[i]=vecx[i]*1;
		vecy[i]=vecy[i]*1;
	}	
	initgraph(&gd, &gm, "C:\\TC\\BGI");
	setcolor(YELLOW);
	for(size_t i=0;i<n;i++){
		if(i==n-1){
			line(vecx[i],vecy[i],vecx[0],vecy[0]);
		}
		else
		line(vecx[i],vecy[i],vecx[i+1],vecy[i+1]);
	}	 
	getch();
	closegraph();
	float A=0.0;
	int sum=0,diff=0;
	for(size_t i=0;i<n;i++){
		if(i==n-1){
			sum=sum+(vecx[i]*vecy[0]);
			diff=diff+(vecx[0]*vecy[i]);
		}
		else{
			sum=sum+(vecx[i]*vecy[i+1]);
			diff=diff+(vecx[i+1]*vecy[i]);
		}
	}
	A=0.5*abs(sum-diff);
	printf("area: %.2f", A);
	return 0;
}
