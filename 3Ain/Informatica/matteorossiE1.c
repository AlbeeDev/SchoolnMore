#include <stdio.h>
void funcname(int vec[],size_t n){
	int isdist=1;
	float sum=0,tot=0;
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<n;j++){
			if(vec[i]==vec[j] && i!=j)
			isdist=0;
			if(vec[i]==vec[j] && i==j)
			break;
		}
		if(isdist==1){
			sum+=vec[i];
			tot+=1.0;
			printf("%i ", vec[i]);
		}
		isdist=1;
	}
	printf("%f", sum/tot);
}
int main(){
int vec[]={11, 17, 13, 30, 22, 19, 23, 23, 21, 21, 25};
size_t n=sizeof(vec)/sizeof(vec[0]);
funcname(vec,n);
}
