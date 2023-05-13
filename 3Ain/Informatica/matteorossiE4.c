#include <stdio.h>
void swap(int *x,int *y){
	int temp = *x;
	*x=*y;
	*y= temp;
}
void funcname(int vec[],size_t n){
	for(size_t i=0;i<n;i++){
		int min_idx=i;
		for(size_t j=i+1;j<n;j++)
			if(vec[j]<vec[min_idx])
			min_idx=j;
		swap(&vec[min_idx],&vec[i]);
		printf("%i ",vec[i]);
	}
}
int main(){
int vec[]={70, 78, 72, 72, 80, 63, 74, 71, 67, 72, 63};
size_t n=sizeof(vec)/sizeof(vec[0]);
funcname(vec,n);
}
