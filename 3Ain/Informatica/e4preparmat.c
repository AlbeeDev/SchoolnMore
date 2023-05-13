#include<stdio.h>
void dupli_arr(int vec[],size_t n){
	int x=0;
	int vec2[]={72,73,80,67,61,75,66,62,80,75};
	size_t m=sizeof(vec2)/sizeof(vec2[0]);
	for(size_t i=0;i<n;i++){
		if(vec[i]>70){
			x=vec2[m-1];
			for(size_t j=i;j<m;j++){
				int temp=vec[j+1]
				vec[j+1]=vec[j];
				int temp
			}	
			m+=1;
			vec2[m-1]=x;
		}
		printf("%i ",vec2[i]);
	}
}
int main(){
	int vec[]={72,73,80,67,61,75,66,62,80,75};
	size_t n=sizeof(vec)/sizeof(vec[0]);
	dupli_arr(vec,n);
}
