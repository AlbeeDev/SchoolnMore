#include<stdio.h>
#include<stdlib.h>
int main(){
	int x,i;
	for(i=0;i<10;i++){
	x=rand()%19-9;
	printf("%i ", x);
	i--;
	}
}
