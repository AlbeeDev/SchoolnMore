#include<stdio.h>
#include<string.h>
int main(){
	int min=1000000;
	int max=-1000000;
	int num;
	FILE *numeri;
	FILE *maxmin;
	numeri=fopen("numeri.txt","r");
	maxmin=fopen("maxmin.txt","w");
	while(fscanf(numeri,"%i",&num)==1){
		if(num<min){
			min=num;
		}
		if(num>max){
			max=num;
		}
	}
	fprintf(maxmin,"Valore minimo: %i\n",min);
	fprintf(maxmin,"Valore massimo: %i\n",max);
	fclose(numeri);
	fclose(maxmin);
}
