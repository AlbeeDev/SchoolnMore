#include <stdio.h>
#include <math.h>
int main(){
	int i, dec=0;
	int bin[8];
	int pot[8]={1,2,4,8,16,32,64,128,};
	printf("inserire un numero binario a 8 bit da destra verso sinistra: \n");
	for(i=0;i<8;i++){
		scanf("%i", &bin[i]);
		if (bin[i]<0 || bin[i]>1){
 		printf("%i non e una cifra binaria, ritenta: \n", bin[i]);
 		i--;
 		}
	}
	for(i=0;i<8;i++)
	if (bin[i]==1){
		dec = dec + pot[i];
	}
		
	for(i=0;i<8;i++){
		printf("%i ", bin[i]);
	}
	printf("= %i", dec);
	return 0;
}
