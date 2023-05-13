#include <stdio.h>
void funcname(int vec[],size_t n){
	vec[n-1]=vec[0];
	for(size_t i=n-1;i>1;i--){
		int temp=vec[i-1];
		vec[i-1]=vec[i];
		vec[i]=temp;
	}
	for(size_t i=0;i<n;i++){
		printf("%i ", vec[i]);
	}
}
int main(){
	int vec[]={81,70,77,68,81,64,73,72,67,70,74};
	int n=sizeof(vec)/sizeof(vec[0])+1;
	funcname(vec,n);
	return 0;
}
