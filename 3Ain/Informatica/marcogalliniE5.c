#include <stdio.h>
void funcname(int vec[],size_t n){
	int isdist=1,iscresc=1;
	int vec2[]={0,0,0,0,0,0,0,0,0,0,0};
	size_t m=sizeof(vec2)/sizeof(vec2[0]);
	for(size_t i=0;i<n;i++){
		for(size_t j=0;j<m;j++){
			if(vec[i]==vec2[j])
			isdist=0;
		}
		if(isdist==1)
		vec2[i]=vec[i];
	}
	for(size_t i=0;i<m;i++){
		if(vec2[i]>vec2[i+1])
		iscresc=0;
	}
	if(iscresc==1)
	printf("vero");
	else
	printf("falso");
}
int main(){
int vec[]={21, 17, 25, 30, 32, 36, 22, 23, 34, 28, 19};
size_t n=sizeof(vec)/sizeof(vec[0]);
funcname(vec,n);
}
