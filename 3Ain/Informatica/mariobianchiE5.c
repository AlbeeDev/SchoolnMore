#include <stdio.h>
void funcname (int vec[],size_t n){
	float sum=0,tot=0;
	for(size_t i=0;i<n;i++){
		if((vec[i]-9)%10==0 || vec[i]-9==0){
			sum=sum+vec[i];
			tot++;
		}
	}
	printf("%f", sum/tot);
}
int main(){
int vec[]={19, 21, 13, 15, 29, 18, 29, 22, 28, 11};
size_t n=sizeof(vec)/sizeof(vec[0]);
funcname(vec,n);
}
