#include<stdio.h>
int main(){
	int num[10], i;
	printf("inserire 10 numeri: \n");
	for(i=0;i<9;i++){
		scanf("%i ", &num[i]);
	}
	printf("\n");
	for(i=9;i>=0;i--){
		printf("%i ", num[i]);
	}
	return 0;
}
