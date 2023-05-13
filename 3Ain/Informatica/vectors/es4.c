#include<stdio.h>
unsigned findmaxmush(int v[8],int result){
	int exc_idx;
	int exc_idx_list[4]={10,10,10,10};
	for(size_t i=0;i<4;i++){
		int max=0;
		for(size_t j=0;j<8;j++){
			int b=1;
			for(size_t k=0;k<4;k++){
				if(j==exc_idx_list[k]){
					b=0;
				}
			}
			if(b==1){
				if(v[j]>max){
					max=v[j];
					exc_idx=j;
				}	
			}		
		}
		exc_idx_list[i]=exc_idx;
		result+=max;
	}
	return result;
}
int main(){
	unsigned result=0;
	int v[8];
	for(size_t i=0;i<8;i++){
		scanf("%i",&v[i]);
	}
	printf("%u",findmaxmush(v,result));
}
