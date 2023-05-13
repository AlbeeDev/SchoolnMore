#include <stdio.h>
void funcname(int vec[],size_t n){
	int x=2,y=0;
	int z=x;
	for(size_t i=0;i<n;i++){
		if(i==z){
		y=x;
		z+=x*z;
		}
		if(i+x<n && y==0){
		int temp=vec[i];
		vec[i]=vec[i+x];
		vec[i+x]=temp;
		}
		else
		y-=1;
		printf("%i ",vec[i]);
	}
}
int main(){
int vec[]={28, 13, 30, 29, 19, 18, 21, 13, 25, 13};
size_t n=sizeof(vec)/sizeof(vec[0]);
funcname(vec,n);
}
